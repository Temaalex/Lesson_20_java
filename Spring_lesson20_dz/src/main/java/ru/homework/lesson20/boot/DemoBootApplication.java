package ru.homework.lesson20.boot;
//Пишем Aviasales для опер.
//		Необходимо реализовать приложение, которое способно:
//		1) Добавлять новые премьеры (с указанием названия, подробного описания, возрастной категории и количество доступных мест)
//		2) Изменять показатели премьеры
//		3) Удалять мероприятие
//		4) Просматривать список всех мероприятий и какого-то конкретного (с подробным описанием)
//
//		5) Покупать билет на мероприятие и сдавать его (если вдруг надо)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.homework.lesson20.boot.service.AviaService;

@SpringBootApplication
public class DemoBootApplication {


	public static void main(String[] args) {

		//Add() Buy()Change()Delete()Look() Sale()
		final ConfigurableApplicationContext ctx1 = SpringApplication.run(DemoBootApplication.class, args);
		ctx1.getBean(AviaService.class).Sale();
	}


}
