package com.oracle.oBootJpa02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "team_seq_gen",
				   sequenceName = "team_seq_generator", //매핑할 DB 시퀸스 이름
				   initialValue = 1,
				   allocationSize = 1) 

public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "team_seq_gen")
	private Long team_id;
	@Column(name = "teamname")
	private String name;

}
