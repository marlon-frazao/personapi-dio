package com.digitalinnovationone.personapidio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovationone.personapidio.dto.request.PersonDTO;
import com.digitalinnovationone.personapidio.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapidio.services.PersonService;
import com.digitalinnovationone.personapidio.services.exceptions.PersonNotFoundException;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid PersonDTO dto) {
		return service.create(dto);
	}
	
	@GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return service.findById(id);
    }
	
	@GetMapping
    public List<PersonDTO> listAll() {
        return service.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return service.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        service.delete(id);
    }
}
