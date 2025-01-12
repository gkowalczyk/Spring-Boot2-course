package com.example.ksb2.model;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.*;

public class Video extends RepresentationModel<Video> {

    @NotNull(message = "Id is required")
    @Min(value = 0, message = "Id should be greater than 0")
    @Max(value = Long.MAX_VALUE, message = "Id should be less than " + Long.MAX_VALUE)
    private long id;

    @NotNull(message = "Title is required")
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String title;

    @NotNull(message = "Url is required")
    @Size(min = 2, message = "Url should have at least 2 characters")
    private String url;

    @Email(message = "Email should be valid")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Video(long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }
}
