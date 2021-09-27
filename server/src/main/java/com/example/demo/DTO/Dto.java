package com.example.demo.DTO;


import javax.validation.constraints.NotBlank;

public class Dto {
    @NotBlank
    String text;


    Dto(){}

    public String getText() {
        return text;
    }
}
