package com.ivanbessoltsev.exampleapplication.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema
public class UpdateUserDTO extends CreateUserDTO {
    @Schema(title = "id", description = "id работника")
    private Integer id;
}

