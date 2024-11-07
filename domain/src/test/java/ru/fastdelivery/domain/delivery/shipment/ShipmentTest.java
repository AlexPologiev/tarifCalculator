package ru.fastdelivery.domain.delivery.shipment;

import com.javadocmd.simplelatlng.LatLng;
import org.junit.jupiter.api.Test;
import ru.fastdelivery.domain.common.currency.CurrencyFactory;
import ru.fastdelivery.domain.common.dimension.Dimension;
import ru.fastdelivery.domain.common.volume.Volume;
import ru.fastdelivery.domain.common.volume.VolumeTest;
import ru.fastdelivery.domain.common.weight.Weight;
import ru.fastdelivery.domain.delivery.pack.Pack;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShipmentTest {

    @Test
    void whenSummarizingWeightOfAllPackages_thenReturnSum() {
        var weight1 = new Weight(BigInteger.TEN);
        var weight2 = new Weight(BigInteger.ONE);

        var volume1 = new Volume(new Dimension(BigInteger.ONE),
                new Dimension(BigInteger.TWO),
                new Dimension(BigInteger.TWO));

        var volume2 = new Volume(new Dimension(BigInteger.ONE),
                new Dimension(BigInteger.TWO),
                new Dimension(BigInteger.TWO));

        LatLng point1 = new LatLng(35,65);
        LatLng point2 = new LatLng(45,96);

        var packages = List.of(new Pack(weight1, volume1), new Pack(weight2, volume2));
        var shipment = new Shipment(packages,
                new CurrencyFactory(code -> true).create("RUB"),
                point1,
                point2);

        var massOfShipment = shipment.weightAllPackages();

        assertThat(massOfShipment.weightGrams()).isEqualByComparingTo(BigInteger.valueOf(11));
    }
}