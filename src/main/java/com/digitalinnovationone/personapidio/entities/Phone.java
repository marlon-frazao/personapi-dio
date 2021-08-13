package com.digitalinnovationone.personapidio.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.digitalinnovationone.personapidio.dto.request.PhoneDTO;
import com.digitalinnovationone.personapidio.entities.enums.PhoneType;

@Entity
@Table(name = "tb_phone")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private PhoneType type;
	
	@Column(nullable = false, unique = true)
	private String number;
	
	public Phone() {}

	public Phone(Long id, PhoneType type, String number) {
		this.id = id;
		this.type = type;
		this.number = number;
	}
	
	public Phone(PhoneDTO dto) {
		id = dto.getId();
		type = dto.getType();
		number = dto.getNumber();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public PhoneDTO toDTO() {
		return new PhoneDTO(this);
	}
}
