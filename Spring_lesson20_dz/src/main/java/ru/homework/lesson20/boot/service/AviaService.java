package ru.homework.lesson20.boot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.homework.lesson20.boot.func.*;

//Пишем Aviasales для опер.
//        Необходимо реализовать приложение, которое способно:
//        1) Добавлять новые премьеры (с указанием названия, подробного описания, возрастной категории и количество доступных мест)
//        2) Изменять показатели премьеры
//        3) Удалять мероприятие
//        4) Просматривать список всех мероприятий и какого-то конкретного (с подробным описанием)
//
//        5) Покупать билет на мероприятие и сдавать его (если вдруг надо)
import javax.annotation.PostConstruct;

@Service
public class AviaService {

    private Logger logger;
    //add,buy,change,delete,look,sale
    @Autowired
    public AviaService(@Qualifier("sale") Logger logger) {
        this.logger = logger;
    }

     public void Add(){
        logger.log("добавлен новый параметр!");
    }
    public void Buy(){
        logger.log("дилет куплен!");
    }
    public void Change(){
        logger.log("наименование изменено!");
    }
    public void Delete(){
        logger.log("удалено!");
    }
    public void Look(){
        logger.log("список билетов 1- кино1, кино2, кино3...");
    }
    public void Sale(){
        logger.log("вы вернули билет!");
    }







}
