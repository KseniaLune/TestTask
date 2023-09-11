package com.example.testtask.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Schema(description = "Exception")
public class ExBody {
    @Schema(name = "message", example = "Letters must be not null.")
    private String message;
    @Schema(name = "error", example = "Validation failed.")
    private List<String> errors;

    public ExBody(String message) {
        this.message = message;
    }
}
