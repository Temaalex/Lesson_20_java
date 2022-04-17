package ru.homework.lesson20.boot.service.interfaces;


import ru.homework.lesson20.boot.domain.Avia;
import ru.homework.lesson20.boot.dto.AviaDto;
import ru.homework.lesson20.boot.entities.AviaEntities;

import java.io.IOException;
import java.util.Collection;

public interface AviaService {

    Collection<Avia> getAll();
    Avia seeOne(Long id);
    void addAvia(Avia avia);
    void deleteAvia(Long id);
    Avia updateAvia(Avia avia);


    void bayTicket(String title) throws IOException;
    void saleTicket(String title) throws IOException;




}
