package ru.fastdelivery.domain.common.height;

import ru.fastdelivery.domain.common.CheckDimensions;

import java.math.BigInteger;

public record Height(BigInteger height) implements CheckDimensions {
    public Height {
        if (isLessThanZero(height)) {
            throw new IllegalArgumentException("Height cannot be below Zero");
        }
    }
}
