package com.example.videoapiapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class Mail {

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is required")
    private String to;
    @NotBlank(message = "Subject is required")
    private String subject;
    @NotBlank(message = "Text is required")
    private String text;
}


