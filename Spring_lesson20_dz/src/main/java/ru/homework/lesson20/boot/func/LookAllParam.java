package ru.homework.lesson20.boot.func;

import ru.homework.lesson20.boot.interfaces.Logger;

public class LookAllParam implements Logger {
    public void  log(Object o){
        System.out.println("Посмотреть все параметры: "+o);
    }
}