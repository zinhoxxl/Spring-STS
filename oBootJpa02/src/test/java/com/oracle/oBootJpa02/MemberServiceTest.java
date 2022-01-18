package com.oracle.oBootJpa02;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.oBootJpa02.domain.Member;
import com.oracle.oBootJpa02.repository.MemberRepository;
import com.oracle.oBootJpa02.service.MemberService;


// 1. @SpringBootTest : 스프링 부트 띄우고 테스트(이게 없으면 @Autowired 다 실패)
// 2. @Transactional : 반복 가능한 테스트 지원, 각각의 테스트를 실행할 때마다 트랜잭션을 시작하고, 
//                     테스트가 끝나면 트랜잭션을 강제로 롤백 (이 어노테이션이 테스트 케이스에서 사용될 때만 롤백)
@SpringBootTest
@Transactional
public class MemberServiceTest {
	// 필드 인젝션
	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;
	
	@BeforeEach
	public void before1() {
		System.out.println("Test BeforeEach Start...");
	}
	
	@Test
	public void memberSave() throws Exception {
		// 조건
		Member member = new Member();
		member.setTeamname("4class");
		member.setName("이진호");
		// 수행
		Member member3 = memberService.join(member);
		// 결과
		System.out.println("MemberServiceTest memberSave member3.getId() -> " 
		                   + member3.getId());
		System.out.println("MemberServiceTest memberSave member3.getName() -> " 
                		   + member3.getName());
		System.out.println("MemberServiceTest memberSave member3.getTeam() -> " 
                           + member3.getTeam());
		
	}
	

}





