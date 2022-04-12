package ru.homework.lesson20.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.homework.lesson20.boot.annotations.Loggable;
import ru.homework.lesson20.boot.entities.AviaEntities;
import ru.homework.lesson20.boot.repository.interfaces.AviaRepository;
import ru.homework.lesson20.boot.service.interfaces.AviaService;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Slf4j
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

//start Transactional
    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,   //+
            isolation = Isolation.READ_COMMITTED, //+
            timeout = 5,
            rollbackFor = { //правило отката
                    EOFException.class,
            },
            noRollbackFor = {
                    FileNotFoundException.class,
                    NullPointerException.class
            }
    )
//finish Transactional
    public void bayTicket(String title) throws IOException {
        List<AviaEntities> title1 = aviaRepository.getByTitle(title);
        if (title1.isEmpty()) {
            aviaRepository.bayOneTicket(title);
            throw new EOFException("Ошибка транзакции, повторите попытку или обратитесь с службу поддержки +9(999)99-999");
        } else {
            log.info("Начало транзакции");
            aviaRepository.bayOneTicket(title);
            log.info("Конец транзакции");
        }

    }

    @Loggable
    @Override
    public void saleTicket(String title){
        aviaRepository.saleOneTicket(title);
    }
}