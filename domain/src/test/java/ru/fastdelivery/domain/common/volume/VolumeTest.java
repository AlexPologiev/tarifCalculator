package ru.fastdelivery.domain.common.volume;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.fastdelivery.domain.common.dimension.Dimension;

import java.math.BigInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VolumeTest {

    @ParameterizedTest
    @DisplayName("Тест сложения")
    @CsvSource("50, 50, 50, 100, 100, 100, 150")
    void addTest(BigInteger l1,
                 BigInteger w1,
                 BigInteger h1,
                 BigInteger l2,
                 BigInteger w2,
                 BigInteger h2,
                 BigInteger expected){
        var volume1 = new Volume(new Dimension(l1),
                new Dimension( w1),
                new Dimension(h1));
        var volume2 = new Volume(new Dimension(l2),
                new Dimension( w2),
                new Dimension(h2));

        var resultVolume = volume2.add(volume1);

        assertThat(resultVolume.length().getDimension()).isEqualTo(expected);
        assertThat(resultVolume.width().getDimension()).isEqualTo(expected);
        assertThat(resultVolume.height().getDimension()).isEqualTo(expected);
    }
}
