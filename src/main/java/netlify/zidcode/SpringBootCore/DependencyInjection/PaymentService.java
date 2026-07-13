package netlify.zidcode.SpringBootCore.DependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay() {
        System.out.println("Payment Done.");
    }
}
