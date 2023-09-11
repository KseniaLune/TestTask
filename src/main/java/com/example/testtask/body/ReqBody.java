package com.example.testtask.body;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Request Body in JSON format")
public class ReqBody {
    @Schema(name = "letters", description = "Not null, not blank, length max = 2 million, only latin lower-case letters", example = "aaabbbccc")
    @NotNull(message = "Letters must be not null.")
    @Length(max = 2000000, message = "Letters length must be smaller than 2 million symbols.")
    @NotBlank(message = "Letters must be not blank.")
    private String letters;
}