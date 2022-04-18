package ru.homework.lesson20.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.*;
import ru.homework.lesson20.boot.domain.Avia;
import ru.homework.lesson20.boot.entities.AviaEntities;
import ru.homework.lesson20.boot.repository.interfaces.AviaRepository;
import ru.homework.lesson20.boot.service.interfaces.AviaService;
import ru.homework.lesson20.boot.service.interfaces.Mapper;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.io.IOException;

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

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            timeout = 5,
            rollbackFor = {
                    EOFException.class,
            },
            noRollbackFor = {
                    FileNotFoundException.class,
                    NullPointerException.class
            }
    )
    @Override
    public void bayTicket(String title){
        aviaRepository.bayOneTicket(title);
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            timeout = 5,
            rollbackFor = {
                    EOFException.class,
            },
            noRollbackFor = {
                    FileNotFoundException.class,
                    NullPointerException.class
            }
    )
    @Override
    public void saleTicket(String title) {
        aviaRepository.saleOneTicket(title);
    }

    @Override
    public void changeTitle(String title, long id){
        aviaRepository.getAviaWhichToBay(title, id);
    }
}