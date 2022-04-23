package com.example.demo;

import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentApi {

    private List<Student> studentList;
    public StudentApi(){
        this.studentList = new ArrayList<>();
    }
    @PostMapping("/addstudent")
    public boolean addStudent(@RequestBody Student student){
        return studentList.add(student);
    }

    @GetMapping("/StudentList")
    public List<Student> getStudentList(){
        return studentList;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentList.stream().filter(student -> student.getId()==id).findFirst().get(); }

    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentList.stream().filter(student -> student.getName().equals(name)).findFirst().get();}

    @GetMapping("/delete/{id}")
    public boolean deleteStudentById(@PathVariable int id){
        Student user =studentList.stream().filter(student -> student.getId()==id).findFirst().get();
        return studentList.remove(user);

    }
    @GetMapping("/deletename/{name}")
    public boolean deleteStudentByName(@PathVariable int name) {
        Student st = studentList.stream().filter(student -> student.getName().equals(name)).findFirst().get();
        return studentList.remove(st);
    }
}

