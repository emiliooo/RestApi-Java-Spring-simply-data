package Emil.demo.Controller;

import Emil.demo.Entity.Student;
import Emil.demo.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

     @Autowired
     private StudentsService studentsService;

     @RequestMapping(method = RequestMethod.GET)
     public Collection<Student> getAllStudents() {
         return studentsService.getAllStudents();
     }

     @RequestMapping(value = "/{id}",method = RequestMethod.GET)
     public Student getStudentById(@PathVariable("id") int id) {
          return studentsService.getStudentById(id);
     }

     @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
     public  void  deleteStudentById(@PathVariable("id") int id) {
           studentsService.removeStudentById(id);
     }

     @RequestMapping(method = RequestMethod.PUT)
     public  void  updateStudent(@RequestBody Student student) {
          studentsService.updateStudent(student);
     }

     @RequestMapping(method = RequestMethod.POST)
     public  void  insertStudent(@RequestBody Student student) {
          studentsService.insertStudent(student);
     }



}
