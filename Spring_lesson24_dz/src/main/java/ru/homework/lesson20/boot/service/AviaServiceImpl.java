package ru.homework.lesson20.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.homework.lesson20.boot.annotations.Loggable;
import ru.homework.lesson20.boot.entities.AviaEntities;
import ru.homework.lesson20.boot.repository.interfaces.AviaRepository;
import ru.homework.lesson20.boot.service.interfaces.AviaService;


@Service
public class AviaServiceImpl implements AviaService {
    private AviaRepository aviaRepository;

    @Autowired
    public AviaServiceImpl(AviaRepository aviaRepository) {
        this.aviaRepository = aviaRepository;
    }
    @Loggable
    @Override
    public void printAll() {
            System.out.println("Всего концертов: " + aviaRepository.count());
            System.out.println("Список билетов: ");
            for (AviaEntities aviaEntity : aviaRepository.findAll()) {
                System.out.println(aviaEntity);
            }
    }
    @Loggable
    @Override
    public void saveNew(String title, int salary, String age, String description, int place) {
        AviaEntities aviaEntities = new AviaEntities(null, title, salary, age, description, place);
        aviaRepository.save(aviaEntities);
    }
    @Loggable
    @Override
    public void delete (long id) {
        aviaRepository.deleteById(id);
    }


    @Loggable
    @Override
    public void changeBD(long id, String title, int salary, String age, String description, int place){
        aviaRepository.deleteById(id);
        AviaEntities aviaEntities = new AviaEntities(null, title, salary, age, description, place);
        aviaRepository.save(aviaEntities);
    }
    @Loggable
    @Override
    public void seeOne(String title){
        System.out.println("Результат поиска");
        System.out.println(aviaRepository.findByTitle(title));
    }



    @Loggable
    @Override
    public void bayTitle(String title, boolean place){
        if(place) {
            System.out.println("Вы купили билет: ");
            System.out.println(aviaRepository.findByTitle(title));
        } else
            System.out.println("Неудача!");
        }
    }





