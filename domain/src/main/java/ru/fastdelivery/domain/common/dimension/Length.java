package ru.fastdelivery.domain.common.dimension;

import java.math.BigInteger;

public class Length extends Dimension implements CheckDimensions {

    public Length(BigInteger dimension) {
        super(dimension);
    }
}
