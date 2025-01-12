package com.example.ksb2.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {

    @GetMapping
    public String getProducts(@RequestParam String name, @RequestParam String surname) {
        return "get products for : " + name + " " + surname;
    }


    @GetMapping("/body")
    public String getProductsByBody(@RequestBody String name) {
        return "get products for : " + name;
    }

    @GetMapping("/header")
    public String getProductsHeader(@RequestHeader String name) {
        return "get products for : " + name;
    }

    @GetMapping("/path/{name}")
    public String getProductsPath(@PathVariable String name) {
        return "get products for : " + name;

    }

    @GetMapping("/param")
    public String getProductsWithParam(@RequestParam String name, @RequestParam(required = false) String surname) {
        return "get products for : " + name + " " + surname;
    }

    @GetMapping("/paramDefault")
    public String getProductsWithParamDefault(@RequestParam String name, @RequestParam(defaultValue = "") String surname) {
        return "get products for : " + name + " " + surname;
    }

    @GetMapping("/response")
    public ResponseEntity<String> getProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("get products for : ");
    }

    @PostMapping
    public String createProducts() {
        return "create product";
    }

    @PutMapping
    public String editProducts() {
        return "edit product";
    }

    @DeleteMapping
    public String deleteProducts() {
        return "delete product";
    }
}
