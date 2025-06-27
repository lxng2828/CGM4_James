package com.codegym.aop_exception_handling.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ten khong duoc de trong")
    @Size(max = 100, message = "ten khong duoc qua 100 ky tu")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 0, message = "tuoi phai lon hon 0")
    @Max(value = 100, message = "tuoi phai nho hon 100")
    private Integer age;

    @NotBlank(message = "email duoc de trong")
    @Email
    @Column(nullable = false, unique = true)
    private String email;

}
