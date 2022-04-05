package ru.homework.lesson20.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.homework.lesson20.boot.service.AviaServiceImpl;
import ru.homework.lesson20.boot.service.interfaces.AviaService;




@SpringBootApplication
public class DemoBootApplication {


	public static void main(String[] args) {

		final ConfigurableApplicationContext ctx1 = SpringApplication.run(DemoBootApplication.class, args);
		final AviaService aviaService =ctx1.getBean(AviaServiceImpl.class);

		aviaService.saveNew("Ад Данте", 2000, "+18", "Новое описание", 1050);
		aviaService.delete(12);
		//aviaService.changeBD(1, "Ад Данте", 2000, "+18", "Новое описание", 1050);
		aviaService.printAll();
		//aviaService.seeOne("Евгений Онегин");
		//aviaService.bayTitle("Евгений Онегин", true);
	}


}
