package com.digitalinnovationone.personapidio.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.digitalinnovationone.personapidio.entities.Phone;
import com.digitalinnovationone.personapidio.entities.enums.PhoneType;

public class PhoneDTO {

	private Long id;

    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
    
    public PhoneDTO() {}

	public PhoneDTO(Long id, PhoneType type, @NotEmpty @Size(min = 13, max = 14) String number) {
		this.id = id;
		this.type = type;
		this.number = number;
	}
	
	public PhoneDTO(Phone entity) {
		id = entity.getId();
		type = entity.getType();
		number = entity.getNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Phone toEntity() {
		return new Phone(this);
	}
}
