package ru.homework.lesson20.boot.service.interfaces;

import org.mapstruct.Mapping;
import ru.homework.lesson20.boot.domain.Avia;
import ru.homework.lesson20.boot.dto.AviaDto;
import ru.homework.lesson20.boot.entities.AviaEntities;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    AviaDto toDto(Avia avia);
    Avia toDomain(AviaDto aviaDto);
    Avia toDomain(AviaEntities aviaEntities);
    AviaEntities toEntity(Avia avia);
}
