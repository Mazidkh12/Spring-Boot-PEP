package netlify.zidcode.SpringBootCore.Server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServer {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Server Bhai";
    }
}
