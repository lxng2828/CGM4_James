package com.codegym.validation.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class User {

    @NotEmpty(message = "ten khong duoc phep de trong")
    private String name;

    @NotEmpty(message = "so dien thoai khong duoc phep de trong")
    @Pattern(regexp = "^(0|\\+84)[3|5|7|8|9][0-9]{8}$", message = "so dien thoai khong hop le")
    private String phoneNumer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", phoneNumer=" + phoneNumer + "]";
    }

}
