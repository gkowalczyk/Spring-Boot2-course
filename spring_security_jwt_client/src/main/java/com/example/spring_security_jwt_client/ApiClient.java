package com.example.spring_security_jwt_client;

import com.auth0.jwt.JWT;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;
import java.util.stream.Stream;

import com.auth0.jwt.algorithms.Algorithm;

@Controller
public class ApiClient {

    private RSAPrivateKey rsaPrivateKey;

    public ApiClient() {
        try {
            rsaPrivateKey = loadPrivateKey("E:\\SynologyDrive\\Dokumenty\\BootCamp" +
                    "\\projekty\\Spring Boot2 Course\\" +
                    "spring_security_jwt_client\\src\\main\\resources\\private_key.pem");
            addBook();
            getBooks();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private RSAPrivateKey loadPrivateKey(String path) throws IOException,
            InvalidKeySpecException, NoSuchAlgorithmException {
        String key = new String(Files.readAllBytes(Paths.get(path)))
                .replaceAll("-----BEGIN PRIVATE KEY-----", "")
                .replaceAll("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] keyBytes = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    private String generateJwt(boolean isAdmin) {
        Algorithm algorithm = Algorithm.RSA256(null, rsaPrivateKey);
        return JWT
                .create()
                .withClaim("sub", "1234567890")
                .withClaim("name", "John Doe")
                .withClaim("admin", isAdmin)
                .withClaim("role", "ROLE_ADMIN")
                .sign(algorithm);
    }

    private void getBooks() {
        String jwt = generateJwt(true);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwt);
        HttpEntity httpEntity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String[]> exchange = restTemplate
                .exchange("http://localhost:8080/api/books",
                HttpMethod.GET,
                httpEntity,
                String[].class);
        Stream.of(Objects.requireNonNull(exchange.getBody()))
                .forEach(System.out::println);
    }

    private void addBook() {
        String jwt = generateJwt(true);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwt);
        String book = "Spring 3";
        HttpEntity httpEntity = new HttpEntity(book, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange("http://localhost:8080/api/books",
                HttpMethod.POST,
                httpEntity,
                Void.class);
    }
}
