package com.ivanbessoltsev.exampleapplication.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(title = "CreateEmployeeDTO", description = "Создание работника")
public class CreateUserDTO {

    @Schema(title = "login", description = "Логин аккаунта")
    private String login;

    @Schema(title = "firstName", description = "Имя")
    private String firstName;

    @Schema(title = "lastName", description = "Фамилия")
    private String lastName;

    @Schema(title = "middleName", description = "Отчество")
    private String middleName;

    @Schema(title = "dateOfEmployment", description = "Дата устройства на работу")
    private LocalDate dateOfEmployment;
}
