package com.oracle.oBootJpa02.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.oracle.oBootJpa02.domain.Member;
import com.oracle.oBootJpa02.domain.Team;

public class JpaMemberRepository implements MemberRepository {
	private final EntityManager em;  // JPA
	
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Member save(Member member) {
		// 팀 저장
		Team team = new Team();
		team.setName(member.getTeamname());
		em.persist(team);
		// 회원 저장  (팀을 저장 하고 그 팀을 회원에 저장)
		member.setTeam(team); //단방향 연관관계 설정, 참조 저장
		em.persist(member);
		return member;
	}

	@Override
	public List<Member> findAll() {                          // 테이블이 아니라 객체 Member
		List<Member> memberList = em.createQuery("select m from Member m", Member.class)
				                  .getResultList();
		return memberList;
	}

	@Override
	public Member findByMember(Long id) {
		//                      Entity        PK
		Member member = em.find(Member.class, id);
		return member;
	}

	@Override
	public int updateByMember(Member member) {
		int result = 0;
		System.out.println("JpaMemberRepository updateByMember member.getId() ->" 
							+ member.getId());
		Member member3 = em.find(Member.class, member.getId());
		//  원래내용 : member3
		if(member3 != null) {
			// 팀 저장
			System.out.println("JpaMemberRepository updateByMember member.getTeamId() -> "
								+ member.getTeamid());
			Team team = em.find(Team.class, member.getTeamid());
			if (team != null) {
				System.out.println("JpaMemberRepository updateByMember member.getTeamname() -> "
									+ member.getTeamname());
				team.setName(member.getTeamname()); // setter를 통해서 teamname만 변함
				em.persist(team);  // 자기가 알아서 업데이트 해줌
			}
			//회원 저장
			System.out.println("JpaMemberRepository updateByMember member.getName() -> "
								+ member.getName());
			member3.setTeam(team);  // 단방향 연관관계 설정, 참조 저장
			member3.setName(member.getName());  // 단방향 연관관계 설정, 참조 저장
			em.persist(member3);
			System.out.println("JpaMemberRepository updateByMember member.getName() ->"
								+ member.getName());
			result = 1;
			
		} else {
			result = 0;
			System.out.println("JpaMemberRepository updateByMember No Exist...");
			
		}
		return result; // 있으면 1리턴, 없으면 0 리턴
	}

	
}
