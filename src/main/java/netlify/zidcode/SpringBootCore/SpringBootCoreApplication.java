package netlify.zidcode.SpringBootCore;

import netlify.zidcode.SpringBootCore.DependencyInjection.OrderService;
import netlify.zidcode.SpringBootCore.PaymentSystem.CreditCard;
import netlify.zidcode.SpringBootCore.PaymentSystem.UPI;
import netlify.zidcode.SpringBootCore.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCoreApplication.class, args);

		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();

//		Student student = context.getBean(Student.class);
//
//		student.setAge(22);
//		student.setName("Mazid Khan");
//		System.out.println(student.getName());
//		System.out.println(student.getAge());
	}
}
