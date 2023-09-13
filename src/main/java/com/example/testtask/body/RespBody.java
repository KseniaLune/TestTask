package com.example.testtask.body;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Schema(description = "Response body in JSON format")
public class RespBody {
    @Schema(name = "result", example = "[c:5,a:3,b:2]")
    private List<String> result;
}
