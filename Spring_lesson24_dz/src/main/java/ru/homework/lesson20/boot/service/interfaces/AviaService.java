package ru.homework.lesson20.boot.service.interfaces;

import ru.homework.lesson20.boot.annotations.Loggable;
import ru.homework.lesson20.boot.entities.AviaEntities;

import java.util.List;


public interface AviaService {

    void printAll();
    void saveNew(String title, int salary, String age, String description, int place);
    void delete(long id);
    void changeBD(long id, String title, int salary, String age, String description, int place);

    void seeOne(String title);

    void bayTitle(String title, boolean place);
}
