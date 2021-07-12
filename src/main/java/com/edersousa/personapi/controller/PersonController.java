package com.edersousa.personapi.controller;

import com.edersousa.personapi.dto.request.PersonDTO;
import com.edersousa.personapi.dto.responose.MessageResponseDTO;
import com.edersousa.personapi.exception.PersonNotFoundException;
import com.edersousa.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/peoples")
@AllArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return service.create(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return service.findById(id);
    }
}
