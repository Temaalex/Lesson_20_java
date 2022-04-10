package ru.homework.lesson20.boot.service.interfaces;


public interface AviaService {

    void printAll();
    void saveNew(String title, int salary, String age, String description, int place);
    void delete(long id);
    void seeOne(String title);

    void changeBD(long id, String title, int salary, String age, String description, int place);


    void testBay(long id, int place);
}
