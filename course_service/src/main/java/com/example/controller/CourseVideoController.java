package com.example.controller;

import com.example.model.CourseVideo;
import com.example.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
public class CourseVideoController {
  @Autowired
  private CourseVideoService service;

  @PostMapping("/add")
  public CourseVideo add(@RequestBody CourseVideo v) {
    return service.addVideo(v);
  }

  @GetMapping("/course/{cid}")
  public List<CourseVideo> list(@PathVariable("cid") Long cid) {
    return service.listByCourse(cid);
  }
}
