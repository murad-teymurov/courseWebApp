package com.company.SimpleWebApp.controller;

import com.company.SimpleWebApp.model.Course;
import com.company.SimpleWebApp.model.Student;
import com.company.SimpleWebApp.repository.CourseRepository;
import com.company.SimpleWebApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
   private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/list")
    public String getAllStudents(Model model ){
     List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
//        ModelAndView modelAndView = new ModelAndView();
//         modelAndView.addObject("students", students);
         return "list";
    }

    @GetMapping("/new")
    public String newAdd(Model model){
        model.addAttribute("student", new Student());

       List<Course> courseList = courseRepository.findAll();
       model.addAttribute("allcourses", courseList);
        return "details";
    }

    @PostMapping("/save")
    public String addStudent(@Valid Student student, BindingResult br, Model model){

        if(br.hasErrors()){
            return "details";
        }
        studentRepository.save(student);
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "list";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam Integer id){
       Optional<Student> optionalStudent = studentRepository.findById(id);

       if(optionalStudent.isPresent()){
           Student student = optionalStudent.get();
           model.addAttribute("student", student);
       }

        List<Course> courseList = courseRepository.findAll();
        model.addAttribute("allcourses", courseList);

       return "update";
    }

    @PostMapping("/delete")
    public String delete(Model model,@RequestParam Integer id){
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            studentRepository.delete(student);
        }
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping( "/name")
    public String getStudentByName(Model model, @RequestParam String name){
       List<Student> students = studentRepository.findByName(name);
       model.addAttribute("students", students);
       return "list";
    }
//    @GetMapping( "/{name}")
//    public String getStudentByName(Model model, @PathVariable String name){
//        List<Student> students = studentRepository.findByName(name);
//        model.addAttribute("students", students);
//        return "list";
//    }



}
