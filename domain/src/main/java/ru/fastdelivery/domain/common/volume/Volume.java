package ru.fastdelivery.domain.common.volume;

import ru.fastdelivery.domain.common.dimension.Dimension;
import ru.fastdelivery.domain.common.dimension.Height;
import ru.fastdelivery.domain.common.dimension.Length;
import ru.fastdelivery.domain.common.dimension.Width;

import java.math.BigDecimal;
import java.math.BigInteger;

public record Volume(Dimension length, Dimension width, Dimension height) {

    public Volume {
    }

    public static Volume zero() {
        return new Volume(
                new Length(BigInteger.ZERO),
                new Width(BigInteger.ZERO),
                new Height(BigInteger.ZERO));
    }

    public Volume add(Volume additionalVolume){
        Dimension length = this.length;
        Dimension additionalLength = additionalVolume.length;
        Dimension resultLength = length.add(additionalLength);
        Dimension width = this.width;
        Dimension additionalWidth = additionalVolume.width;
        Dimension resultWidth = width.add(additionalWidth);
        Dimension height = this.height;
        Dimension additionalHeight = additionalVolume.height();
        Dimension resultHeight = height.add(additionalHeight);

        return new Volume(
                resultLength,
                resultWidth,
                resultHeight);
    }

    public BigDecimal calculateVolume(){
        BigInteger length = this.length.getDimension();
        BigInteger width = this.width.getDimension();
        BigInteger height = this.height.getDimension();

        BigInteger vol = length.multiply(width).multiply(height);
        return new BigDecimal(vol)
                .divide(BigDecimal.valueOf(1_000_000_000), 1, BigDecimal.ROUND_UP);
    }





}
