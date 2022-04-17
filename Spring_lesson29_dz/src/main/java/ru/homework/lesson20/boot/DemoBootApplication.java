package ru.homework.lesson20.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.homework.lesson20.boot.service.AviaServiceImpl;
import ru.homework.lesson20.boot.service.interfaces.AviaService;

import java.io.IOException;


@SpringBootApplication
public class DemoBootApplication {
	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx1 = SpringApplication.run(DemoBootApplication.class, args);
		final AviaService aviaService =ctx1.getBean(AviaServiceImpl.class);


		// транзакция
//		try {
//			aviaService.bayTicket("Незнайка на луне, часть 1");
//		} catch (IOException e) {
//			System.out.println("Error "+e);
//		}

		// транзакция
		try {
			aviaService.saleTicket("Незнайка на луне, часть 1");
		} catch (IOException e) {
			System.out.println("Error "+e);
		}
	}
}
