package ru.fastdelivery.presentation.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "Данные для расчета стоимости доставки")
public record CalculatePackagesRequest(
        @Schema(description = "Список упаковок отправления",
                example = "[{\"weight\": 4056.45}," +
                        "{\"length\": 350}," +
                        "{\"width\": 1200}," +
                        "{\"height\": 1000}]")
        @NotNull
        @NotEmpty
        List<CargoPackage> packages,

        @Schema(description = "Трехбуквенный код валюты", example = "RUB")
        @NotNull
        String currencyCode,

        @Schema(description = "Стартовая точка, град", example = "33.123")
        Point destination,

        @Schema(description = "Конечная точка, град", example = "12ю125")
        Point departure
) {
}
