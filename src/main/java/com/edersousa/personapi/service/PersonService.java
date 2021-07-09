package com.edersousa.personapi.service;

import com.edersousa.personapi.dto.MessageResponseDTO;
import com.edersousa.personapi.entity.Person;
import com.edersousa.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository repository;

    public MessageResponseDTO create(Person person){
        Person savedPerson = repository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with id " + savedPerson.getId())
                .build();
    }
}
