package com.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class VideoDaoImpl implements VideoDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void setVideo(long id, String title, String url) {
        Video video = new Video(id, title, url);
        String sql = "INSERT INTO VIDEOS VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, video.videoId(), video.title(), video.url());
    }

    @Override
    public List<Video> findAll() {
        String sql = "SELECT * FROM VIDEOS";
        List<Video> videoList = new ArrayList<>();
        List<Map<String, Object>> videosMap = jdbcTemplate.queryForList(sql);
        videosMap.forEach(element -> videoList.add(new Video(
                Long.parseLong(String.valueOf(element.get("video_id"))),
                String.valueOf(element.get("video_title")),
                String.valueOf(element.get("url")))));
        return videoList;
    }

    @Override
    public void updateVideo(Video video) {
        String sql = "UPDATE VIDEOS SET video_title = ?, url = ? WHERE video_id = ?";
        jdbcTemplate.update(sql, video.title(), video.url(), video.videoId());

    }

    @Override
    public void deleteVideo(Long id) {
        String sql = "DELETE FROM VIDEOS WHERE video_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Video getOne(Long id) {

        String sql = "Select * from VIDEOS where video_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Video(
                        rs.getLong("video_id"),
                        rs.getString("video_title"),
                        rs.getString("url")
                ), id);
    }
}
