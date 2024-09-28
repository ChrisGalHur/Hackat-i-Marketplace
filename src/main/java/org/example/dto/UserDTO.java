package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.ValidationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Second name cannot be empty")
    private String secondName;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Password cannot be empty")
    private String password;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 0, message = "Age cannot be negative")
    private int age;

    private String role;

    public void validateAge(int age) {
        if (age < 0) {
            throw new ValidationException("Age cannot be negative");
        }
    }
}
