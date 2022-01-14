package com.oracle.oBootJpa01.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

// JPA 에서의 DTO
@Entity
public class Member { // 테이블명
	// PK(@Id)
	@Id
	private Long   id; // 칼럼
	private String name;
	
	
	// getter / setter 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
