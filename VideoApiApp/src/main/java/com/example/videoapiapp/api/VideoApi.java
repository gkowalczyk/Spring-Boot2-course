package com.example.videoapiapp.api;

import com.example.videoapiapp.aspect.SendMailAspect;
import com.example.videoapiapp.model.Video;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoApi {

    private final List<Video> videos;

    public VideoApi() {
        videos = new ArrayList<>();
        videos.add(new Video(1L, "Harry Potter", LocalDate.of(2001, 11, 4), "Warner Bros"));
        videos.add(new Video(2L, "The Lord of the Rings", LocalDate.of(2001, 12, 19), "New Line Cinema"));
        videos.add(new Video(3L, "The Matrix", LocalDate.of(1999, 3, 31), "Warner Bros"));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Video>> getVideos() {
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @PostMapping
    @SendMailAspect
    public ResponseEntity<String> addVideo(@Validated @RequestBody Video video) {
        return videos.add(video) ? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

