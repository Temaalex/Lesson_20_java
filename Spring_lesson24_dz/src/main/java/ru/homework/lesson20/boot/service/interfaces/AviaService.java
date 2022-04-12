package ru.homework.lesson20.boot.service.interfaces;


import ru.homework.lesson20.boot.annotations.Loggable;

import java.io.IOException;

public interface AviaService {

    void printAll();
    void saveNew(String title, int salary, String age, String description, int place);
    void delete(long id);
    void seeOne(String title);

    void changeBD(long id, String title, int salary, String age, String description, int place);



    @Loggable
    void changeTitle(String title, long id);


    @Loggable
    void bayTicket(String title) throws IOException;

    @Loggable
    void saleTicket(String title);
}
