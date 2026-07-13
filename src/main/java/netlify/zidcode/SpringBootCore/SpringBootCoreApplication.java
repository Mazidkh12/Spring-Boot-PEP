package netlify.zidcode.SpringBootCore;

import netlify.zidcode.SpringBootCore.PaymentSystem.CreditCard;
import netlify.zidcode.SpringBootCore.PaymentSystem.UPI;
import netlify.zidcode.SpringBootCore.Student.Stundent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreApplication.class, args);

		Stundent std1 = new Stundent("Mazid Khan", 22);
		System.out.println(std1.getAge());
		System.out.println(std1.getName());
	}
}
