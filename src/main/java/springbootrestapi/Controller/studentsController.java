package springbootrestapi.Controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestapi.Entity.Students;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Student")
public class studentsController {
    @GetMapping("getStudent")
    public ResponseEntity<Students> getstudents()
    {
        Students student= new Students(1,"Nikky","jaiswal");
        return new ResponseEntity<>(student ,HttpStatus.OK);

    }

    @GetMapping("/getStudentslist")
    public ResponseEntity<List<Students>> getStudents()
    {List<Students> students= new ArrayList<Students>();
    students.add(new Students(2,"Nik","jaiswal"));
    students.add(new Students(3,"Nik","jai"));
    students.add(new Students(4,"Nik","jais"));
    return new ResponseEntity<>(students,HttpStatus.CREATED);}

    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentByIdPath(@PathVariable int id)
    {
        Students student= new Students(id,"Nik","jai");
        return ResponseEntity.ok(student);
    }
    @PostMapping("/create")

    public ResponseEntity<Students> createStudent(@RequestBody Students student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<Students> updateStudent(@RequestBody Students student,@PathVariable int id)
    {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  ResponseEntity.ok(student);
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        System.out.println(id);
        return ResponseEntity.ok("deleted sucessfully");
    }
}
