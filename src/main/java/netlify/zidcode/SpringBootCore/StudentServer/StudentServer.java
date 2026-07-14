package netlify.zidcode.SpringBootCore.StudentServer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {

    @PostMapping("/create")
    public String storeStudent() {
        return """
                id: 1,
                name: Mazid Khan,
                Dep: CSE,
                Age: 22
                """;
    }
}
