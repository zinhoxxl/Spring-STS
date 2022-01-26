package com.oracle.oBootMybatis03.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis03.domain.Member;

@Repository
public class MemberJpaRepositoryImpl implements MemberJpaRepository {

	@Autowired
	private final EntityManager em;
	    
	public MemberJpaRepositoryImpl(EntityManager em) {
	    	this.em = em;
	}

	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public List<Member> findAll() {
		List<Member> memberList = em.createQuery("select m from Member m", Member.class)
                .getResultList();
		return memberList;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public void updateByMember(Member member) {
		//em.persist(member);	
		em.merge(member);	
		return;
	}

}
