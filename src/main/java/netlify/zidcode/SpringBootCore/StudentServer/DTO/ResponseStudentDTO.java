package netlify.zidcode.SpringBootCore.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseStudentDTO {
    private int id;
    private String name;
    private int age;
    private String department;
    private String email;
}

