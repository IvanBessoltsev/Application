package com.ivanbessoltsev.exampleapplication.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ivanbessoltsev.exampleapplication.enums.Relation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(title = "EmployeeFilter", description = "Фильтр работников")
public class RequestFilterDTO {

    @Schema(title = "firstName", description = "Фильтр по имени ")
    private String firstName;

    @Schema(title = "lastName", description = "Фильтр по фамилии")
    private String lastName;

    @Schema(title = "middleName", description = "Фильтр по отчеству")
    private String middleName;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @Schema(title = "start date of employment", description = "Дата устройства ОТ")
    private LocalDate startDateOfEmployment;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @Schema(title = "end date of employment", description = "Дата устройства ДО")
    private LocalDate endDateOfEmployment;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @Schema(title = "start date of dismissal", description = "Дата увольнения ОТ")
    private LocalDate startDateOfDismassal;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @Schema(title = "end date of dismissal", description = "Дата увольнения ДО")
    private LocalDate endDateOfDismassal;

    @Schema(title = "relation", description = "Связь с родственником")
    private String relation;


}
