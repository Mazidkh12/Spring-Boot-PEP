package netlify.zidcode.SpringBootCore.StudentServer.Controller;

import jakarta.validation.Valid;
import netlify.zidcode.SpringBootCore.StudentServer.DTO.RequestStudentDTO;
import netlify.zidcode.SpringBootCore.StudentServer.DTO.ResponseStudentDTO;
import netlify.zidcode.SpringBootCore.StudentServer.DTO.UpdateStudentResponseDTO;
import netlify.zidcode.SpringBootCore.StudentServer.Entity.Student;
import netlify.zidcode.SpringBootCore.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseStudentDTO> storeStudent(
            @RequestBody RequestStudentDTO dto) {

        ResponseStudentDTO result = studentService.studentValidate(dto);

        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) throws Exception {

        Student student = studentService.getStudentById(id);

        if(student == null){
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @Valid @RequestBody Student student){
        UpdateStudentResponseDTO result = studentService.studentUpdate(id, student);
        if(result == null)
        {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        Student student = studentService.deleteStudent(id);
        if(student == null) {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return ResponseEntity.status(200).body("Student deleted");
    }
}