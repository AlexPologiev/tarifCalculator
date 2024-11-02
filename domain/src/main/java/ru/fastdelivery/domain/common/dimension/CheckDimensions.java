package ru.fastdelivery.domain.common.dimension;
import java.math.BigInteger;


public interface CheckDimensions {

    long UPPER_LIMIT = 1500;
    BigInteger NORMALIZE_VALUE = BigInteger.valueOf(50);
    default boolean isLessThanZero(BigInteger dimension) {
        return BigInteger.ZERO.compareTo(dimension) > 0;
    }

    default boolean isMoreThanLimit(BigInteger dimension) {
        return dimension.compareTo(BigInteger.valueOf(UPPER_LIMIT)) > 0;
    }

}
