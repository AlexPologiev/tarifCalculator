package ru.fastdelivery.domain.common.dimension;


import lombok.Data;
import java.math.BigInteger;

@Data
public class Dimension implements CheckDimensions {
    public final BigInteger dimension;

    public Dimension(BigInteger dimension) {
        if (isLessThanZero(dimension)) {
            throw new IllegalArgumentException("Dimension cannot be below Zero");
        } else if (isMoreThanLimit(dimension)) {
            throw new IllegalArgumentException("Dimension cannot be above limit");
        }
        this.dimension = dimension;
    }

    public Dimension add(Dimension dimension) {
        BigInteger baseDimension = this.getDimension();
        BigInteger additionalDimension = dimension.getDimension();
        BigInteger resultDimension = baseDimension.add(additionalDimension);

        return new Dimension(resultDimension);
    }
}
