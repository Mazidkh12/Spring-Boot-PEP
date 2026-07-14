package netlify.zidcode.SpringBootCore.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Portfolio {
    @GetMapping("/myself")
    public String myself() {
        return """
                <h1>Mazid Khan</h1>
                <p> Hii, this is Mazid Khan </p>
                <ul>
                <li> Github link: <a>https://github.com/Mazidkh12 </a></li>
                <li> LinkedIn link: <a>https://linkedin.com/Mazidkhan12 </a></li>
                </ul>
                """;
    }

    @GetMapping("/skills")
    public String mySkills() {
        return """
                <h1>Full Stack Developer</h1>
                <p> I am a passionate Full Stack Developer. I am a critical thinker and problem solver </p>
                <ul>
                <li> Java Spring Boot </li>
                <li> DSA </li>
                <li> MERN </li>
                </ul>
                """;
    }

    @GetMapping("/edu")
    public String edu() {
        return """
                <h1>Bachelor of Technology</h1>
                <p> I am currently pursuing B. Tech in CSE at Lovely Professional University </p>
                <ul>
                <li> Java Spring Boot </li>
                <li> DSA </li>
                <li> MERN </li>
                </ul>
                """;
    }

    @GetMapping("/projects")
    public String projects() {
        return """
                <h1>AlphaInvest Agent</h1>
                <p> it takes a company name, does its research, and decides whether to invest or pass — with the reasoning behind its decision. </p>
                <ul>
                <li> Java Spring Boot </li>
                <li> DSA </li>
                <li> MERN </li>
                </ul>
                """;
    }
}
