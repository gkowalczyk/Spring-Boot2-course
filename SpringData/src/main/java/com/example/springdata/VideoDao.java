package com.example.springdata;

import java.util.List;

public interface VideoDao {

    void setVideo(long id, String title, String url);

    List<Video> findAll();

    void updateVideo(Video newVideo);

    void deleteVideo(Long id);

    Video getOne(Long id);
}
