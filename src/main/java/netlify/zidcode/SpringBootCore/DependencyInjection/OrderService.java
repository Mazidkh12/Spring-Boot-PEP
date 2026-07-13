package netlify.zidcode.SpringBootCore.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
//    @Autowired // field injection
    private PaymentService paymentService;

    @Autowired // constructor injection
    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    setter injection
//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
