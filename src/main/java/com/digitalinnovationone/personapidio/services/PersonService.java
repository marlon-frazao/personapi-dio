package com.digitalinnovationone.personapidio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.personapidio.dto.request.PersonDTO;
import com.digitalinnovationone.personapidio.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapidio.entities.Person;
import com.digitalinnovationone.personapidio.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public MessageResponseDTO create(PersonDTO dto) {
		Person person = new Person(dto, dto.getPhones());
		Person savedPerson = repository.save(person);
		
		MessageResponseDTO response = createMessageResponse("Person successfully create with ID ", savedPerson.getId());
		
		return response;
	}
	
	private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return new MessageResponseDTO(s + id2);
    }
}
