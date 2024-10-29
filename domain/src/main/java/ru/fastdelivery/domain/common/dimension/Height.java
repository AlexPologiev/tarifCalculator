package ru.fastdelivery.domain.common.dimension;

import lombok.Data;

import java.math.BigInteger;

public class Height extends Dimension  implements CheckDimensions {

    public Height(BigInteger dimension) {
        super(dimension);
    }
}
