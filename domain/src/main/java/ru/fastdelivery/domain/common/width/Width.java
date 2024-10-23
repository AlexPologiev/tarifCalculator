package ru.fastdelivery.domain.common.width;

import ru.fastdelivery.domain.common.CheckDimensions;

import java.math.BigInteger;

public record Width(BigInteger width)  implements CheckDimensions {

    public Width {
        if (isLessThanZero(width)){
            throw new IllegalArgumentException("Width  cannot be below Zero");

        }
    }
}
