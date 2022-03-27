package ru.homework.lesson20.boot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.homework.lesson20.boot.annotations.Loggable;
import ru.homework.lesson20.boot.interfaces.Logger;

@Service
public class AviaService {

    private Logger logger;
    //add,buy,change,delete,look,sale
    @Autowired
    public AviaService(@Qualifier("buy") Logger logger) {
        this.logger = logger;
    }

     public void Add(){
        logger.log("добавлен новый параметр!");
    }
    @Loggable
    public void Buy1(){
        logger.log("дилет куплен!");
    }
    @Loggable
    public void Buy2(){
        throw new RuntimeException();
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
