package ru.homework.lesson20.boot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.homework.lesson20.boot.entities.AviaEntities;

import java.util.List;

public interface AviaRepository extends JpaRepository<AviaEntities, Long> {

    List<AviaEntities> deleteById (long id);
    List<AviaEntities> findByTitle(String a);

}

