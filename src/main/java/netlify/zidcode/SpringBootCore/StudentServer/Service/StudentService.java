package netlify.zidcode.SpringBootCore.StudentServer.Service;

import jakarta.validation.Valid;
import netlify.zidcode.SpringBootCore.StudentServer.DTO.RequestStudentDTO;
import netlify.zidcode.SpringBootCore.StudentServer.DTO.ResponseStudentDTO;
import netlify.zidcode.SpringBootCore.StudentServer.DTO.UpdateStudentResponseDTO;
import netlify.zidcode.SpringBootCore.StudentServer.Entity.Student;
import netlify.zidcode.SpringBootCore.StudentServer.Exception.InvalidEmailException;
import netlify.zidcode.SpringBootCore.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseStudentDTO studentValidate(RequestStudentDTO dto) {

        if (!isValidEmail(dto.getEmail())) {
            throw new InvalidEmailException("Invalid email format");
        }

        Student student = mapToStudent(dto);
        studentRepository.save(student);

        return mapToResponseDTO(student);
    }

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public UpdateStudentResponseDTO studentUpdate(
            int id,
            @Valid Student updateStudentRequestDTO) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setName(updateStudentRequestDTO.getName());
        student.setAge(updateStudentRequestDTO.getAge());
        student.setUpdatedAt(LocalDateTime.now());

        studentRepository.save(student);

        return mapToUpdateResponseDTO(student);
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
        student.setEmail(createStudentRequestDTO.getEmail());

        return student;
    }

    private ResponseStudentDTO mapToResponseDTO(Student student) {
        ResponseStudentDTO createStudentResponseDTO = new ResponseStudentDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDept());
        createStudentResponseDTO.setEmail(student.getEmail());

        return createStudentResponseDTO;

    }

    private UpdateStudentResponseDTO mapToUpdateResponseDTO(Student student) {

        UpdateStudentResponseDTO dto = new UpdateStudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setDept(student.getDept());

        return dto;
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}