package com.edersousa.personapi.controller;

import com.edersousa.personapi.dto.MessageResponseDTO;
import com.edersousa.personapi.entity.Person;
import com.edersousa.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/peoples")
@AllArgsConstructor
public class PersonController {

    private PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody Person person){
        return service.create(person);
    }
}
