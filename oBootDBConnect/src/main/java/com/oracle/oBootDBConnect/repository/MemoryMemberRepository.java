package com.oracle.oBootDBConnect.repository;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.oracle.oBootDBConnect.domain.Member1;



public class MemoryMemberRepository implements MemberRepository {
	private static Map<Long, Member1> store = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public Member1 save(Member1 member1) {
		System.out.println("MemoryMemberRepository save Start...");
		member1.setId(++sequence); //하나씩 증가시키겠다
		store.put(member1.getId(), member1); // 맵의 키를 id로!
		return member1; // DB가 아닌 메모리에 저장
	}

	@Override
	public List<Member1> findAll() {
		System.out.println("MemoryMemberRepository findAll Start...");
		// store 의 value(Member1)
		List<Member1> listMember = new ArrayList<>(store.values());
		System.out.println("MemoryMemberRepository finaAll listMember.size() ->" + listMember.size());
		return listMember;
	}

}
