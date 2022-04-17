package ru.homework.lesson20.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avia {

    private Long id;
    private String title;
    private int salary;
    private String age;
    private String description;
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
