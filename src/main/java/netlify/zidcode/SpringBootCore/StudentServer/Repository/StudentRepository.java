package netlify.zidcode.SpringBootCore.StudentServer.Repository;

import netlify.zidcode.SpringBootCore.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}