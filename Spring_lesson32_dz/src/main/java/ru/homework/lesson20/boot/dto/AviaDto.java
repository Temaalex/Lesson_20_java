package ru.homework.lesson20.boot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class AviaDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String title;
    @JsonProperty
    private int salary;
    @JsonProperty
    private String age;
    @JsonProperty
    private String description;
    @JsonProperty
    private int place;
}
