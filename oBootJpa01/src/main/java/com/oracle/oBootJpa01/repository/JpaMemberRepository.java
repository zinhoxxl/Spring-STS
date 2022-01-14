package com.oracle.oBootJpa01.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.oracle.oBootJpa01.domain.Member;

public class JpaMemberRepository implements MemberRepository {
	private final EntityManager em; // JPA사용?-> EntityManager
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Member save(Member member) {
		// JPA 저장
		em.persist(member);
		return member;
	}

	@Override
	public List<Member> findAll() { //Member -> Entity의 Member
		List<Member> memberList = em.createQuery("select a from Member a", Member.class) // a로하면 둘다 a로 맞추기
				                  .getResultList(); // 이걸 붙여야 리스트로 돌려줌  
		return memberList;
	}

	@Override
	public List<Member> findByNames(String name) {
		String pname = name + '%';
		System.out.println("JpaMemberRepository findByNames name -> " + name);
		List<Member> memberList = em.createQuery("select m from Member m where name Like :name", 
				                                  Member.class) // :name (?) 이거임  
				                  .setParameter("name", pname)  // pname -> :name
				                  .getResultList();
		System.out.println("JpaMemberRepository memberList.size() -> " + memberList.size());
		return memberList;
		
	}

}
