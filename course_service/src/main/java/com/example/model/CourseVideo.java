package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "course_videos")
public class CourseVideo {
  @Id @GeneratedValue
  private Long id;
  public Long getId() {
    return id;
}
  public void setId(Long id) {
    this.id = id;
  }
  private Long courseId;
  public Long getCourseId() {
    return courseId;
}
  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }
  private String title;
  public String getTitle() {
    return title;
}
  public void setTitle(String title) {
    this.title = title;
  }
  private String videoUrl;
  
  public String getVideoUrl() {
    return videoUrl;
  }
  public void setVideoUrl(String videoUrl) {
    this.videoUrl = videoUrl;
  }
}
