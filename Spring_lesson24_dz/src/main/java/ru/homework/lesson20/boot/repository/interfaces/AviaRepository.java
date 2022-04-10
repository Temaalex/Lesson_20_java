package ru.homework.lesson20.boot.repository.interfaces;

import org.springframework.data.jpa.repository.*;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.homework.lesson20.boot.entities.AviaEntities;

import java.util.List;

@Repository
public interface AviaRepository extends JpaRepository<AviaEntities, Long> {

    List<AviaEntities> deleteById (long id);
    List<AviaEntities> findByTitle(String a);
    
    List<AviaEntities> getById(long id);

    @Modifying
    @Query("update AviaEntities u set u.id = :id where u.place = :place")
    void updatePlace(@Param(value = "id") long id, @Param(value = "place") int place);

}

