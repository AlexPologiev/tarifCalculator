package ru.fastdelivery.domain.delivery.shipment;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;
import ru.fastdelivery.domain.common.currency.Currency;
import ru.fastdelivery.domain.common.volume.Volume;
import ru.fastdelivery.domain.common.weight.Weight;
import ru.fastdelivery.domain.delivery.pack.Pack;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 * @param packages упаковки в грузе
 * @param currency валюта объявленная для груза
 */
public record Shipment(
        List<Pack> packages,
        Currency currency,
        LatLng destinationPoint,
        LatLng departurePoint
) {
    private static final int SCALE = 5;
    public Weight weightAllPackages() {
        return packages.stream()
                .map(Pack::weight)
                .reduce(Weight.zero(), Weight::add);
    }

    public Volume volumeAllPackages() {
        return packages.stream()
                .map(Pack::volume)
                .reduce(Volume.zero(), Volume::add);
    }

    public BigDecimal distanceShipment(){
        BigDecimal distance = BigDecimal.valueOf(LatLngTool.distance(destinationPoint,
                departurePoint,
                LengthUnit.KILOMETER));
        return distance.round(new MathContext(SCALE));
    }


}
