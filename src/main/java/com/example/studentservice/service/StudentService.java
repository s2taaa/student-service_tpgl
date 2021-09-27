package com.example.studentservice.service;

import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public Student save(Student c);
    public List<Student> getAll();
    public ResponseTemplateVO get(Long id);
    public Student update(Student c);
    public void delete(Long id);
}
