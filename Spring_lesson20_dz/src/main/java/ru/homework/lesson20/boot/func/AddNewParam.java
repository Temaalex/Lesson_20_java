package ru.homework.lesson20.boot.func;

import ru.homework.lesson20.boot.interfaces.Logger;

public class AddNewParam implements Logger {
    public void  log(Object o){
        System.out.println("Добавить новые параметры: "+o);
    }
}
