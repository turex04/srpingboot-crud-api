package com.example.demospring.student;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java. util.List;

@RestController
@RequestMapping(path = "/api") //base api path
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    /*
    * fullPath /api/students
    * method GET
    * access public
    * description get all students
    */
    @GetMapping(path = "/students")
    public List<Student> getStudents() {
        return  studentService.getStudents();
    }
    /*
    * fullPath /api/students/{id}
    * method GET
    * access public
    * description get student by id
    * */
    @GetMapping(path = "/students/{id}")
    public Student getStudent(@PathVariable Long id){

        return studentService.getStudent(id);
    }
    /*
    * fullPath /api/students
    * method POST
    * access public
    * description create a student
    * */
    @PostMapping( value = "/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    /*
    * fullPath /api/students/{id}
    * method PUT
    * access public
    * description update a student
    * */
    @PutMapping( value = "/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent(id, student);
    }

    @DeleteMapping( path = "/students/{id}")
    public void deleteStudent(@PathVariable Long id){
         studentService.deleteStudent(id);
    }

}
