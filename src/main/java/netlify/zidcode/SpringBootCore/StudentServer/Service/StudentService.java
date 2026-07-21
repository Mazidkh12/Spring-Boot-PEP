package netlify.zidcode.SpringBootCore.StudentServer.Service;

import netlify.zidcode.SpringBootCore.StudentServer.DTO.RequestStudentDTO;
import netlify.zidcode.SpringBootCore.StudentServer.DTO.ResponseStudentDTO;
import netlify.zidcode.SpringBootCore.StudentServer.Entity.Student;
import netlify.zidcode.SpringBootCore.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseStudentDTO studentValidate(RequestStudentDTO createStudentRequestDTO) {

        Student student = mapToStudent(createStudentRequestDTO);
        studentRepository.save(student);
        return mapToResponseDTO(student);
    }

    public Student getStudentById(int id) throws Exception {
        return studentRepository.findById(id).orElseThrow(()->new Exception());
    }

    public Student studentUpdate(int id, Student student) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        result.setName(student.getName());
        result.setAge(student.getAge());
        result.setDept(student.getDept());
        result.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(result);
    }

    public Student deleteStudent(int id) {
        Student result = studentRepository.findById(id).orElse(null);
        if(result == null) {
            return null;
        }
        studentRepository.delete(result);
        return result;
    }

    private Student mapToStudent(RequestStudentDTO createStudentRequestDTO) {
        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDept(createStudentRequestDTO.getDept());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private ResponseStudentDTO mapToResponseDTO(Student student) {
        ResponseStudentDTO createStudentResponseDTO = new ResponseStudentDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDept());

        return createStudentResponseDTO;

    }
}