package co.edu.icesi.introspringboot2.controller;


import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.mapper.StudentMapper;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public String student(Model model) {
        var students = studentService.getAllStudents();
        model.addAttribute("greeting", "Hola mundo");
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        return "student";
    }

    @GetMapping("/detail/{id}") //student/detail/24
    public String detail(Model model, @PathVariable("id") long id) {
        try {
            var student = studentService.getStudentByID(id);
            model.addAttribute("student", student);
            return "studentdetail";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/detail") //student/detail?code=A00111&name=Alfa
    public String detailByCode(Model model, @RequestParam("code") String code) {
        var student = studentService.getStudentByCode(code);
        model.addAttribute("student", student);
        return "studentdetail";
    }


    @PostMapping
    public String saveStudent(@ModelAttribute Student student) {
        //Almacenar
        studentService.createStudent(
                studentMapper.toDTO(student)
        );
        return "redirect:/student";
    }


}
