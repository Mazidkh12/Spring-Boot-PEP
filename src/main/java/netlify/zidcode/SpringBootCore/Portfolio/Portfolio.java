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
                </ul?
                """;
    }
}
