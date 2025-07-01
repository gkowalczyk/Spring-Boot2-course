package com.example.spring_security_jwt;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class BookApi {

    private List<String> bookList;

    public BookApi() {
        this.bookList = new ArrayList<>();
        bookList.add("Spring Boot 1");
        bookList.add("Spring Boot 2");
    }

    @GetMapping("api/books")
    public List<String> getBookList() {
        return bookList;
    }

    @PostMapping("api/books")
    public void setBookList(@RequestBody String book) {
        this.bookList.add(book);
    }
}
