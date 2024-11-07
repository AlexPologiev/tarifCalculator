package ru.fastdelivery.domain.common.dimension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.*;

public class DimensionTest {

    @Test
    @DisplayName("Попытка создать отрицательный габарит -> исключение")
    void whenDimensionLessThanZero_thenThrowException() {
        var dimension = BigInteger.valueOf(-1);
        assertThatThrownBy(() -> new Dimension(dimension))
                .isInstanceOf( IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Попытка создать габарит больше лимита -> исключение")
    void whenDimensionMoreThanLimit_thenThrowException(){
        var dimension = BigInteger.valueOf(1501);
        assertThatThrownBy(() -> new Dimension(dimension))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Попытка создать габарит  заданных пределах -> обьект создан")
    void whenDimensionIsNormal(){
        var dimension = BigInteger.valueOf(1000);
        var PackageDimension = new Dimension(dimension);
        Assertions.assertNotNull(PackageDimension);
    }

    @ParameterizedTest
    @DisplayName("Тест метода normalise ")
    @CsvSource({ "1, 50",
                "50, 50",
                "75, 100" })
    void normaliseMethodTest(BigInteger baseDimension, BigInteger expected){
        var packDimension = new Dimension(baseDimension);
        var dimension = packDimension.getDimension();
        assertThat(dimension).isEqualTo(expected);
    }

    @Test
    @DisplayName("Сложеие двух габаритов 100 + 150 -> 250 ")
    void addMethodTest(){
        var dimension1 = new Dimension(BigInteger.valueOf(100));
        var dimension2 = new Dimension(BigInteger.valueOf(150));
        var resultDimension = dimension1.add(dimension2);

        assertThat(resultDimension.getDimension())
                .isEqualTo(BigInteger.valueOf(250));
    }
















}
