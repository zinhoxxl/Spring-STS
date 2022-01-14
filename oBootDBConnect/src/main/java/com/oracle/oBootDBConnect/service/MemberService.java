package com.oracle.oBootDBConnect.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.oBootDBConnect.domain.Member1;
import com.oracle.oBootDBConnect.repository.MemberRepository;


@Service
public class MemberService {
	private final MemberRepository memberRepository;
	// MemberRepository memberRepository = new MemberRepository(); 이제 이방법 안쓸꺼임
	// 이제는 이렇게 함!
	// 어노테이션으로 연결
	
	    @Autowired 
		public MemberService(MemberRepository memberRepository) {
			this.memberRepository = memberRepository;
		}
	    
	    // 회원 가입
	    public Long join(Member1 member1) {
	    	        System.out.println("MemberService join Start...");
	    			memberRepository.save(member1);
	    			return member1.getId();
	    }
	    
	    // 전체 회원 조회
	    public List<Member1> allMembers() {
	    			System.out.println("MemberService allMembers Start...");
	    			List<Member1> memList = null;
	    			memList = memberRepository.findAll();
	    			System.out.println("memList.size() -> " + memList.size());
	    			return memList;
	    }
	    
}
