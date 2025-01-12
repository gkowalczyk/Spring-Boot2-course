package com.example.ksb2.api;

import com.example.ksb2.model.Video;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/videos")
public class VideoApi {

    private List<Video> videos = new ArrayList<>();

    public VideoApi() {
        videos.add(new Video(1L, "WPROWADZENIE DO ARCHITEKTURY MIKROSERWISÓW - WYKŁAD", "https://youtu.be/ImKvgCMJ_ro"));
        videos.add(new Video(2L, "KOŃCZYMY APLIKACJE CHATU W SPRINGU I WDRAŻAMY JĄ NA SERWER VPS", "https://youtu.be/vKtFeOXCkHM"));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Video>> getVideos() {
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Video> getVideosById(@PathVariable Long id) {

        Optional<Video> first = videos.stream()
                .filter(video -> video.getId() == id)
                .findFirst();
        return first.map(video -> {
            video.add(linkTo(VideoApi.class).slash(video.getId()).withSelfRel());
            return ResponseEntity.ok(video);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
    @PostMapping
    public ResponseEntity<String> addVideo(@Validated @RequestBody Video video) {
        return videos.add(video) ? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity<Video> updateVideo(@RequestBody Video newVideo) {
        Optional<Video> first =
                videos.stream()
                        .filter(video -> video.getId() == newVideo.getId())
                        .findFirst();
        if (first.isPresent()) {
            videos.remove(first.get());
            videos.add(newVideo);
            return new ResponseEntity<>(newVideo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> deleteVideo(@PathVariable Long id) {
        Optional<Video> first =
                videos.stream()
                        .filter(video -> video.getId() == id)
                        .findFirst();
        if (first.isPresent()) {
            videos.remove(first.get());
                     return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

