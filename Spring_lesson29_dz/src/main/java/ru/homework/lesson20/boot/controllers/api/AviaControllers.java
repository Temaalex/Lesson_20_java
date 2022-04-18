package ru.homework.lesson20.boot.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.homework.lesson20.boot.dto.AviaDto;
import ru.homework.lesson20.boot.entities.AviaEntities;
import ru.homework.lesson20.boot.service.interfaces.AviaService;
import ru.homework.lesson20.boot.service.interfaces.Mapper;

import java.util.Collection;
import java.util.stream.Collectors;


@RequestMapping("/api/v1/avia")
@RestController
public class AviaControllers {
    private AviaService aviaService;
    private Mapper mapper;

    @Autowired
    public AviaControllers(AviaService aviaService, Mapper mapper) {
        this.aviaService = aviaService;
        this.mapper = mapper;
    }
    @GetMapping
    public Collection<AviaDto> getAllAvia(){
        return aviaService.getAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public AviaDto getAvia(@PathVariable("id") Long id){
        return mapper.toDto(aviaService.seeOne(id));
    }
    @PostMapping
    public void addAvia(@RequestBody AviaDto aviaDto){
        aviaService.addAvia(mapper.toDomain(aviaDto));
    }
    @DeleteMapping("/{id}")
    public void deleteAvia(@PathVariable("id") Long id){
        aviaService.deleteAvia(id);
    }
    @PutMapping("/{id}")
    public void updateAvia(@RequestBody AviaDto aviaDto, @PathVariable("id") Long id){
        aviaService.updateAvia(mapper.toDomain(aviaDto));
    }
    @PostMapping("/{title}")
    public void saleTicket(@PathVariable("title") String title) {
        aviaService.saleTicket(title);
    }
    @PostMapping("/sale/{title}")
    public void bayTicket(@PathVariable("title") String title) {
        aviaService.bayTicket(title);
    }
    @PostMapping("/updateTitle/{title}/{id}")
    public void changeTitle(@PathVariable("title") String title, @PathVariable Long id){
        aviaService.changeTitle(title, id);
    }

}
