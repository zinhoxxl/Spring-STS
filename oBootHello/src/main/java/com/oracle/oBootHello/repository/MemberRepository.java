package com.oracle.oBootHello.repository;

import java.util.List;

import com.oracle.oBootHello.domain.Member1;

public interface MemberRepository {
	Member1 save(Member1 member1); // 파라미터를 받아서 저장
	List<Member1> findAll();

}
