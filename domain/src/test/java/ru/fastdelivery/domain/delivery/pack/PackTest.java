package ru.fastdelivery.domain.delivery.pack;

import org.junit.jupiter.api.Test;
import ru.fastdelivery.domain.common.dimension.Dimension;
import ru.fastdelivery.domain.common.volume.Volume;
import ru.fastdelivery.domain.common.volume.VolumeTest;
import ru.fastdelivery.domain.common.weight.Weight;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PackTest {

    @Test
    void whenWeightMoreThanMaxWeight_thenThrowException() {
        var weight = new Weight(BigInteger.valueOf(150_001));
        var volume1 = new Volume(new Dimension(BigInteger.ONE),
                new Dimension(BigInteger.TWO),
                new Dimension(BigInteger.TWO));
        assertThatThrownBy(() -> new Pack(weight, volume1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenWeightLessThanMaxWeight_thenObjectCreated() {
        var volume1 = new Volume(new Dimension(BigInteger.ONE),
                new Dimension(BigInteger.TWO),
                new Dimension(BigInteger.TWO));
        var actual = new Pack(new Weight(BigInteger.valueOf(1_000)), volume1);
        assertThat(actual.weight()).isEqualTo(new Weight(BigInteger.valueOf(1_000)));
    }
}