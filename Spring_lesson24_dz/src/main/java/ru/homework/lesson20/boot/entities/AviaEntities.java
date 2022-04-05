package ru.homework.lesson20.boot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "avia")
public class AviaEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
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
