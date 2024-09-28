package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {

    @NotNull(message = "Name of the activity cannot be empty")
    private String name;

    @NotNull(message = "Description of the activity cannot be empty")
    private String description;

    @NotNull(message = "Max capacity of the activity cannot be empty")
    private int capacity;
}
