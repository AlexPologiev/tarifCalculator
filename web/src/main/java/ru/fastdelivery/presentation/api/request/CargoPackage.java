package ru.fastdelivery.presentation.api.request;

import com.javadocmd.simplelatlng.LatLng;
import io.swagger.v3.oas.annotations.media.Schema;

import java.awt.*;
import java.math.BigInteger;

public record CargoPackage(
        @Schema(description = "Вес упаковки, граммы", example = "5667.45")
        BigInteger weight,

        @Schema(description = "Длина упаковки, мм", example = "1200")
        BigInteger length,

        @Schema(description = "Ширина упаковки, мм", example = "1200")
        BigInteger width,

        @Schema(description = "Высота упаковки, мм", example = "1200")
        BigInteger height




) {
}
