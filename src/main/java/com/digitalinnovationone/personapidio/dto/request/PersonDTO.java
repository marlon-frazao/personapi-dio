package com.digitalinnovationone.personapidio.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.digitalinnovationone.personapidio.entities.Person;
import com.digitalinnovationone.personapidio.entities.Phone;


public class PersonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;
	
	@NotEmpty
    @CPF
	private String cpf;
	
	@NotNull
	private String birthDate;
	
	@Valid
    @NotEmpty
	private List<PhoneDTO> phones = new ArrayList<>();
	
	public PersonDTO() {}

	public PersonDTO(String firstName, String lastName, String cpf, String birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}
	
	public PersonDTO(Person entity) {
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		cpf = entity.getCpf();
		birthDate = entity.getBithDate().toString();
	}
	
	public PersonDTO(Person entity, List<Phone> phones) {
		this(entity);
		phones.forEach(phone -> this.phones.add(phone.toDTO()));
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}
	
	public Person toEntity() {
		return new Person(this, phones);
	}
}
