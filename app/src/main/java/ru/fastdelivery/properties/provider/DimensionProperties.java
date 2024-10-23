package ru.fastdelivery.properties.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigInteger;

@ConfigurationProperties("dimensions")
public class DimensionProperties {

    private BigInteger upperLimit;
}
