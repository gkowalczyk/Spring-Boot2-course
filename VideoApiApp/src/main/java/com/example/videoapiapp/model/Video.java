package com.example.videoapiapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class Video {


    @Min(value = 0, message = "Id should be greater than 0")
    private final long id;

    @Size(min = 2, message = "Title should have at least 2 characters")
    private final String title;

    @NotNull(message = "Data is required")
    private final LocalDate date;

    @NotNull(message = "Producer is required")
    private final  String producer;
}
