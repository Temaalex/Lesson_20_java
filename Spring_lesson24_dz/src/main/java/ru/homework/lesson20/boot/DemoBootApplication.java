package ru.homework.lesson20.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import ru.homework.lesson20.boot.entities.AviaEntities;
import ru.homework.lesson20.boot.service.AviaServiceImpl;
import ru.homework.lesson20.boot.service.interfaces.AviaService;

import javax.persistence.EntityManagerFactory;
import java.util.List;


@SpringBootApplication
public class DemoBootApplication {
	public static void main(String[] args) {

		final ConfigurableApplicationContext ctx1 = SpringApplication.run(DemoBootApplication.class, args);
		final AviaService aviaService =ctx1.getBean(AviaServiceImpl.class);

		//aviaService.printAll();
		//aviaService.saveNew("Ад Данте", 2000, "+18", "Новое описание", 1050);
		//aviaService.delete(15);
		//aviaService.changeBD(15, "Супер Новый концерт", 1000, "18", "Новое описание", 1500 );
		//aviaService.seeOne("Лебидиное озеро");
		aviaService.testBay(15, 1501);


	}


}
