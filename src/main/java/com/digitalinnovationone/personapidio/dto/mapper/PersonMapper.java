package com.digitalinnovationone.personapidio.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.digitalinnovationone.personapidio.dto.request.PersonDTO;
import com.digitalinnovationone.personapidio.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO dto);
	
	PersonDTO toDTO(Person entity);
}
