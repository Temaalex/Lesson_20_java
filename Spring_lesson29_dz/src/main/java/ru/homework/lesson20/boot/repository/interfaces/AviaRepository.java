package ru.homework.lesson20.boot.repository.interfaces;

import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;
import ru.homework.lesson20.boot.domain.Avia;
import ru.homework.lesson20.boot.entities.AviaEntities;

import java.util.List;


public interface AviaRepository extends JpaRepository<AviaEntities, Long> {

     @Transactional
     @Modifying
     @Query("UPDATE AviaEntities avia SET avia.place = (avia.place-1) where avia.title = :patternTitle")
     Integer bayOneTicket(String patternTitle);


     @Transactional
     @Modifying
     @Query("UPDATE AviaEntities avia SET avia.place = (avia.place+1) where avia.title = :patternTitle")
     Integer saleOneTicket(String patternTitle);

     @Transactional
     @Query("from AviaEntities avia where avia.title = :pattern")
     List<AviaEntities> getByTitle(String pattern);
}