package ru.fastdelivery.domain.common.dimension;


import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class Dimension implements CheckDimensions {
    private final BigInteger dimension;

    public Dimension(BigInteger dimension) {
        if (isLessThanZero(dimension)) {
            throw new IllegalArgumentException("Dimension cannot be below Zero");
        } else if (isMoreThanLimit(dimension)) {
            throw new IllegalArgumentException("Dimension cannot be above limit");
        }
        this.dimension = normalise(dimension);
    }

    public Dimension add(Dimension dimension) {
        BigInteger baseDimension = this.getDimension();
        BigInteger additionalDimension = dimension.getDimension();
        BigInteger resultDimension = baseDimension.add(additionalDimension);

        return new Dimension(resultDimension);
    }

    public BigInteger normalise(BigInteger dimension) {
        BigInteger remainder = dimension.remainder(NORMALIZE_VALUE);
        BigInteger roundedDimension = dimension.subtract(remainder);

        if (roundedDimension.compareTo(dimension) < 0) {
            return roundedDimension.add(NORMALIZE_VALUE);
        } else {
            return dimension;
        }
    }
}
