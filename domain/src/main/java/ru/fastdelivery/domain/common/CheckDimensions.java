package ru.fastdelivery.domain.common;

import java.math.BigInteger;


public interface CheckDimensions {



    default boolean isLessThanZero(BigInteger dimension){
        return BigInteger.ZERO.compareTo(dimension) > 0;
    }

    default boolean isMoreThanLimit(BigInteger dimension){
        return dimension.compareTo(BigInteger.valueOf(1500)) > 0;
    }
}
