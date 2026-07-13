package netlify.zidcode.SpringBootCore;

import org.springframework.stereotype.Component;

@Component
public class CreditCard implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Paying via Card");
    }
}
