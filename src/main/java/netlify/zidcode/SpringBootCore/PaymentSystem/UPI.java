package netlify.zidcode.SpringBootCore.PaymentSystem;

import org.springframework.stereotype.Component;

@Component
public class UPI implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Paying Via UPI");
    }
}
