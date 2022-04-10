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
    public void seeOne(String title){
        System.out.println("Результат поиска");
        System.out.println(aviaRepository.findByTitle(title));
    }

    @Loggable
    @Override
    public void changeBD(long id, String title, int salary, String age, String description, int place) {
        aviaRepository.getById(id);
        AviaEntities aviaEntities = new AviaEntities(id, title, salary, age, description, place);
        aviaRepository.save(aviaEntities);
    }
    @Loggable
    @Override
    public void changeTitle(String title, long id){
        aviaRepository.getAviaWhichToBay(title, id);
    }

    @Loggable
    @Override
    public void bayTicket(String title){
        aviaRepository.bayOneTicket(title);
    }
    @Loggable
    @Override
    public void saleTicket(String title){
        aviaRepository.saleOneTicket(title);
    }
}