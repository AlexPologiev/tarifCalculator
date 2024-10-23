package ru.fastdelivery.domain.common.length;

import ru.fastdelivery.domain.common.CheckDimensions;

import java.math.BigInteger;

public record Length(BigInteger length) implements CheckDimensions {

    public Length {
        if (isLessThanZero(length)){
            throw new IllegalArgumentException("Length cannot be below Zero");
        } else if (isMoreThanLimit(length)){
            throw new IllegalArgumentException("Length cannot be above limit");
        }
    }
}
