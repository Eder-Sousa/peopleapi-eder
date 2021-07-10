package com.edersousa.personapi.service;

import com.edersousa.personapi.dto.request.PersonDTO;
import com.edersousa.personapi.dto.responose.MessageResponseDTO;
import com.edersousa.personapi.entity.Person;
import com.edersousa.personapi.mapper.PersonMapper;
import com.edersousa.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository repository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO create(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = repository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with id " + savedPerson.getId())
                .build();
    }
}
