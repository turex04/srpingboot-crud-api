package com.example.demospring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(
            1L,
            "Joseph",
            "joseph@gmail.com",
            LocalDate.of(1986, Month.MAY, 4),
            21
            ),
            new Student (
                    2L,
                    "Isaac",
                    "isaac@gmail.com",
                    LocalDate.of(1992, Month.JULY, 24),
                    28
            )
    ));

    public List<Student> getStudents(){

        return students;
    }

    public Student getStudent(Long id){
        return students.stream().filter(st -> st.getId().equals(id)).findFirst().get();
    }

    public void addStudent(Student student) {

        students.add(student);
    }

    public void updateStudent(Long id, Student student) {
        for (int index = 0; index < students.size(); index++){
            Student st = students.get(index);
            if(st.getId().equals(id)){
                students.set(index,student );
            }
        }

    }

    public void deleteStudent(Long id) {
        students.removeIf(st -> st.getId().equals(id));
    }
}
