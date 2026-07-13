package netlify.zidcode.SpringBootCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCoreApplication.class, args);
		CreditCard card = context.getBean(CreditCard.class);
		card.pay();

		UPI upi = context.getBean(UPI.class);
		upi.pay();
	}
}
