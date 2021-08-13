package com.digitalinnovationone.personapidio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalinnovationone.personapidio.dto.request.PersonDTO;
import com.digitalinnovationone.personapidio.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapidio.entities.Person;
import com.digitalinnovationone.personapidio.repositories.PersonRepository;
import com.digitalinnovationone.personapidio.services.exceptions.PersonNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Transactional
	public MessageResponseDTO create(PersonDTO dto) {
		Person person = new Person(dto, dto.getPhones());
		Person savedPerson = repository.save(person);
		
		MessageResponseDTO response = createMessageResponse("Person successfully create with ID ", savedPerson.getId());
		
		return response;
	}
	
	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return person.toDTO();
    }
	
	@Transactional(readOnly = true)
	public List<PersonDTO> listAll() {
        List<Person> people = repository.findAll();
        return people.stream().map(Person::toDTO).collect(Collectors.toList());
    }
	
	@Transactional
	public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatedPerson = personDTO.toEntity();
        updatedPerson.setId(id);
        Person savedPerson = repository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }
	
	@Transactional
	public void delete(Long id) throws PersonNotFoundException {
        repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        repository.deleteById(id);
    }
	
	private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return new MessageResponseDTO(s + id2);
    }
}
