package com.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class Start {

    private final VideoDao videoDao;

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        videoDao.setVideo(1, "title", "url");
        videoDao.setVideo(2, "title2", "url2");
        videoDao.setVideo(3, "title3", "url3");
        videoDao.findAll().forEach(System.out::println);
        videoDao.updateVideo(new Video(1L, "new title", "new url"));
        videoDao.deleteVideo(2L);

        System.out.println("Get id = 1= ");
        System.out.println(videoDao.getOne(1L));
    }
    }
