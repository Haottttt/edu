package com.example.service;

import com.example.model.Homework;
import com.example.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {
  @Autowired
  private HomeworkRepository repo;

  public Homework submit(Homework hw) {
    hw.setSubmitTime(LocalDateTime.now());
    hw.setCorrected(false);
    return repo.save(hw);
  }

  public List<Homework> listByStudent(Long sid) {
    return repo.findByStudentId(sid);
  }

  public List<Homework> listByCourse(Long cid) {
    return repo.findByCourseId(cid);
  }

  public Homework correct(Long id, Integer grade, String feedback) {
    Optional<Homework> opt = repo.findById(id);
    if (!opt.isPresent()) throw new RuntimeException("作业不存在");
    Homework hw = opt.get();
    hw.setCorrected(true);
    hw.setGrade(grade);
    hw.setFeedback(feedback);
    return repo.save(hw);
  }
}
