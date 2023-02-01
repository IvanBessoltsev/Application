package com.ivanbessoltsev.exampleapplication.filter;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(title = "MongoFilter", description = "Фильтр транспорта")
public class TransportFilter {

    @Schema(title = "maker", description = "Фильтр по производителю ")
    private String maker;

    @Schema(title = "model", description = "Фильтр по модели")
    private String model;
}
