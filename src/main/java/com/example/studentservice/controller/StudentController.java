package com.example.studentservice.controller;

import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping
    public String create(@RequestBody Student student){
        studentService.save(student);
        return "saved";
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO get(@PathVariable("id") Long id){
        return studentService.get(id);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Student student){
        studentService.update(student);
        return "updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        studentService.delete(id);
        return "deleted";
    }
}
