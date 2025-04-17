package com.example.controller;

import com.example.model.Homework;
import com.example.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

  @Autowired
  private HomeworkService service;

  @PostMapping("/submit")
  public Homework submit(@RequestBody Homework hw) {
    return service.submit(hw);
  }

  @GetMapping("/student/{sid}")
  public List<Homework> byStudent(@PathVariable Long sid) {
    return service.listByStudent(sid);
  }

  @GetMapping("/course/{cid}")
  public List<Homework> byCourse(@PathVariable Long cid) {
    return service.listByCourse(cid);
  }

  @PostMapping("/correct/{id}")
  public Homework correct(@PathVariable Long id,
                          @RequestParam Integer grade,
                          @RequestParam String feedback) {
    return service.correct(id, grade, feedback);
  }
}
