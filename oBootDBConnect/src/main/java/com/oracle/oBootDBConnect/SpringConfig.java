package com.oracle.oBootDBConnect;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oracle.oBootDBConnect.repository.JdbcMemberRepository;
import com.oracle.oBootDBConnect.repository.MemberRepository;
import com.oracle.oBootDBConnect.repository.MemoryMemberRepository;

// 방법2.  (여기서 교체를 하자) 샷건효과 방지 문제점최소화 방법!
@Configuration
public class SpringConfig {
	private final DataSource dataSource;
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	// 오라클이랑 인젝션 쫙 !
	// DI
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
		// return new JdbcMemberRepository(dataSource);
	}

}
