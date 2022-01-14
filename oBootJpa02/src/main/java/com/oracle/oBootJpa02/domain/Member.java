package com.oracle.oBootJpa02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
// getter / setter 생성해줌
@Getter
@Setter
// name = "member_seq_gen"(Entity(여기서) 쓰는이름)
// sequenceName = "member_seq_generator" (DB에서 쓰는 이름) 매핑할 DB 이름
@SequenceGenerator(name = "member_seq_gen", 
                   sequenceName = "member_seq_generator",
                   initialValue = 1,
                   allocationSize = 1)
// 물리적인 이름 member1 , 하지만 사용은 Member로 한다(논리적인 이름)
@Table(name = "member1")
public class Member {
	
	@Id
	//시퀸서 적용 (오라클타입)       ~시퀸서를 쓰겠다!!!
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	                generator = "member_seq_gen")
	@Column(name = "member_id", precision = 10)
	private Long id;
	@Column(name = "user_name", length = 50)
	private String name;
	
	// FK
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	
	//버퍼로 사용 -> (특정 필드를 칼럼에 매핑하지 않음 (매핑 무시 , 연관관계 맺지 않겠다!))
	@Transient 
	private Long teamid;
	@Transient
	private String teamname; // createMemberForm 의 teamname
	

}
