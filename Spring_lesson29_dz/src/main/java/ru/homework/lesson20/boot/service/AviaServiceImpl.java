package ru.homework.lesson20.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Propagation;
import ru.homework.lesson20.boot.domain.Avia;
import ru.homework.lesson20.boot.entities.AviaEntities;
import ru.homework.lesson20.boot.repository.interfaces.AviaRepository;
import ru.homework.lesson20.boot.service.interfaces.AviaService;
import ru.homework.lesson20.boot.service.interfaces.Mapper;
import org.springframework.transaction.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class AviaServiceImpl implements AviaService {
    private AviaRepository aviaRepository;
    private Mapper mapper;

    @Autowired
    public AviaServiceImpl(AviaRepository aviaRepository, Mapper mapper) {
        this.aviaRepository = aviaRepository;
        this.mapper = mapper;
    }
    @Override
    public Collection<Avia> getAll() {return aviaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());}
    @Override
    public Avia seeOne(Long id){return mapper.toDomain(aviaRepository.getById(id));}
    @Override
    public void addAvia(Avia avia) {aviaRepository.save(mapper.toEntity(avia));}
    @Override
    public void deleteAvia(Long id){aviaRepository.deleteById(id);}
    @Override
    public Avia updateAvia(Avia avia) {return mapper.toDomain(aviaRepository.save(mapper.toEntity(avia)));}

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
            System.out.println(aviaRepository.getByTitle(title));
            log.info("Конец транзакции");
        }
    }

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
    @Override
    public void saleTicket(String title) throws IOException{
        List<AviaEntities> title1 = aviaRepository.getByTitle(title);
        if (title1.isEmpty()) {
            aviaRepository.bayOneTicket(title);
            throw new EOFException("Ошибка транзакции, повторите попытку или обратитесь с службу поддержки +9(999)99-999");
        } else {
            log.info("Начало транзакции");
            aviaRepository.saleOneTicket(title);
            System.out.println(aviaRepository.getByTitle(title));
            log.info("Конец транзакции");
        }
    }
}