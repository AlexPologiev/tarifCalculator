package ru.fastdelivery.domain.common;

import java.math.BigInteger;

public interface CheckDimensions {

    default boolean isLessThanZero(BigInteger dimension){
        return BigInteger.ZERO.compareTo(dimension) > 0;
    }
}
