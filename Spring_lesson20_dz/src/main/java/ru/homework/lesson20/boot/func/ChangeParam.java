package ru.homework.lesson20.boot.func;

import ru.homework.lesson20.boot.interfaces.Logger;

public class ChangeParam implements Logger {
    public void  log(Object o){
        System.out.println("Изменить параметры: "+o);
    }
}