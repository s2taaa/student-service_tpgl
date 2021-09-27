package com.example.studentservice.service;

import com.example.studentservice.VO.Faculty;
import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.repository.StudentRepo;
import com.example.studentservice.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Student save(Student c) {
        return studentRepo.save(c);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public ResponseTemplateVO get(Long id) {
       ResponseTemplateVO vo = new ResponseTemplateVO();
       Student student = studentRepo.findById(id).get();
       vo.setStudent(student);

        Faculty faculty =
                restTemplate.getForObject("http://localhost:9001/api/faculty/"
                +student.getFacultyId(),Faculty.class);

        vo.setFaculty(faculty);
        return vo;
    }

    @Override
    public Student update(Student c) {
        return studentRepo.save(c);
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);

    }
}
