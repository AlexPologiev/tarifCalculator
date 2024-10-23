package ru.fastdelivery.domain.common.volume;

import ru.fastdelivery.domain.common.height.Height;
import ru.fastdelivery.domain.common.length.Length;
import ru.fastdelivery.domain.common.width.Width;

import java.math.BigInteger;

public record Volume(Length length, Height height, Width width) {

    public static BigInteger volume;

    public Volume {
        BigInteger l = this.length().length();
        BigInteger h = this.height().height();
        BigInteger w = this.width().width();
        volume = l.multiply(h)
                .multiply(w);
    }
}
