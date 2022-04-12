package ru.homework.lesson20.boot.repository.interfaces;

import org.springframework.data.jpa.repository.*;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.homework.lesson20.boot.entities.AviaEntities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQuery;
import java.util.List;

 @Repository
public interface AviaRepository extends JpaRepository<AviaEntities, Long> {

     List<AviaEntities> deleteById(long id);

     List<AviaEntities> findByTitle(String a);

     List<AviaEntities> getById(long id);



     @Transactional
     @Query("from AviaEntities avia where avia.title = :pattern")
     List<AviaEntities> getByTitle(String pattern);

     @Transactional
     @Modifying
     @Query(name = "update.avia")
     Integer getAviaWhichToBay(String pattern, long patternId);

     @Transactional
     @Modifying
     @Query(name = "bay.avia")
     Integer bayOneTicket(String patternTitle);
     @Transactional
     @Modifying
     @Query(name = "sale.avia")
     Integer saleOneTicket(String patternTitle);



 }