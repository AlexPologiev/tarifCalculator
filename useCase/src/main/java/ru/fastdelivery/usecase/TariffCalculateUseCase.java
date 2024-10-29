package ru.fastdelivery.usecase;

import lombok.RequiredArgsConstructor;
import ru.fastdelivery.domain.common.price.Price;
import ru.fastdelivery.domain.delivery.shipment.Shipment;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class TariffCalculateUseCase {
    private final WeightPriceProvider weightPriceProvider;
    private final VolumePriceProvider volumePriceProvider;

    public Price calc(Shipment shipment) {
        var weightAllPackagesKg = shipment.weightAllPackages().kilograms();
        var volumeAllPackages = shipment.volumeAllPackages();
        var minimalPrice = weightPriceProvider.minimalPrice();

        var costByWeight = weightPriceProvider
                .costPerKg()
                .multiply(weightAllPackagesKg);


        var costByVolume = volumePriceProvider
                .costPerCubicMeter()
                .multiply(volumeAllPackages.calculateVolume());

                return costByVolume
                         .max(costByWeight.max(minimalPrice));
    }

    public Price minimalPrice() {
        return weightPriceProvider.minimalPrice();
    }
}
