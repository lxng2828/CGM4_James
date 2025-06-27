package com.codegym.formregistervalidate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotBlank(message = "First name is required")
    @Size(min = 5, max = 45, message = "First name must be between 5 and 45 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 5, max = 45, message = "Last name must be between 5 and 45 characters")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^(0[3|5|7|8|9])+([0-9]{8})$", message = "Invalid Vietnamese phone number")
    private String phoneNumber;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
}
