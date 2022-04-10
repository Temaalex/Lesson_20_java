package ru.homework.lesson20.boot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "update.avia", query = "UPDATE AviaEntities avia SET avia.title = :pattern where avia.id = :patternId"),
    @NamedQuery(name = "bay.avia", query = "UPDATE AviaEntities avia SET avia.place = (avia.place-1) where avia.title = :patternTitle"),
    @NamedQuery(name = "sale.avia", query = "UPDATE AviaEntities avia SET avia.place = (avia.place+1) where avia.title = :patternTitle"),
})
@Entity
@Table(name = "avia")
public class AviaEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private  String title;
    @Column(name = "salary")
    private int salary;
    @Column(name = "age")
    private String age;
    @Column(name = "description")
    private String description;
    @Column (name="place")
    private int place;

    @Override
    public String toString() {
        return String.format(
                "Компазиция - %s. " +
                        "Цена - %d рублей. %n" +
                        "Возрастная котешория: %s.%n" +
                        "Описание: %s. " +
                        "Количество мест: %d.",
                title,
                salary,
                age,
                description,
                place
        );
    }
}
