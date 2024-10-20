package com.vscodetesting.kyler.models;
import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Beer implements Serializable {

    @NotBlank(message = "id is mandatory")
    private String id;

    @NotBlank(message = "Type is mandatory")
    private String type;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "description is mandatory")
    private String description;
}

