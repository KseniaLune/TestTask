package com.example.testtask.body;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@Schema(description = "Response body in JSON format")
public class RespBody {
    @Schema(name = "result", example = "letter:count")
    private Map<Character, Integer> result;
}
