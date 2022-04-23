package ru.homework.lesson20.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.homework.lesson20.boot.domain.Avia;
import ru.homework.lesson20.boot.entities.AviaEntities;
import ru.homework.lesson20.boot.service.AviaServiceImpl;
import ru.homework.lesson20.boot.service.interfaces.AviaService;

import java.io.IOException;


@SpringBootApplication
public class DemoBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoBootApplication.class, args);
	}
}
