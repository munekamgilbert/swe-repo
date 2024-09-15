package edu.mum.cs.cs425.demowebapps.eregistrar.controller;

import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import edu.mum.cs.cs425.demowebapps.eregistrar.domain.Student;

@Controller
public class HomePageController {
    private StudentService studentService;

    @GetMapping(value = {"/","/eregistrar/home","/eregistrar/home/index"})
    public String displayHomePage(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "home/index";
    }



    @GetMapping(value = {"student/new"})
    public String displayNewStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "home/student/new";
    }
    @PostMapping(value = {"student/add"})
    public String addNewStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping(value = {"student/edit"})
    public String displayEditStudentForm(@RequestParam("studentId") long studentId, Model model){
        model.addAttribute("student", studentService.getStudentById(studentId));
        return "home/student/edit";
    }
    @PutMapping(value = {"student/update"})
    public String editStudent(Student student){
        studentService.updateStudent(student);
        return "home/student/edit";
    }
    @PostMapping(value = {"student/delete"})
    public String deleteStudent(@RequestParam("studentId") long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/";
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

}
