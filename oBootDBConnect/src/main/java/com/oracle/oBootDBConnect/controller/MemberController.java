package com.oracle.oBootDBConnect.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.oBootDBConnect.domain.Member1;
import com.oracle.oBootDBConnect.service.MemberService;


@Controller
public class MemberController {
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private final MemberService memberService;
	
	//    생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌
	//    객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 함
	//    이전 테스트에서는 개발자가 직접 주입했고, 여기서는 @Autowired에 의해 스프링이 주입
	
	//    스프링 빈을 등록하는 2가지 방법
	//    컴포넌트 스캔과 자동 의존관계 설정
	//    자바 코드로 직접 스프링 빈 등록하기
	
	//    @Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록된다.
	//    @Controller
	//    @Service
	//    @Repository

	// 어노테이션을 이용한 디펜던스 인젝션
	@Autowired    // 컴포넌트를 뽑아서 알아서 집어넣음
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@GetMapping(value = "/members/new")
	public String createForm() {
		System.out.println("MemberController /members/new Start...");
		return "members/createMemberForm";
	} // 읽기만 할때! (navigating, read)
	
	
	@PostMapping(value = "/members/new")
		public String create(Member1 form) {
		Member1 member = new Member1();
		member.setName(form.getName());
		memberService.join(member);
		return "redirect:/";
	} // 저장,수정 할때!! (executeUpdate)
	
	
	@GetMapping(value = "/members")
	public String memberList(Model model) {
		logger.info("memberList Start...");
		List<Member1> memberLists = memberService.allMembers();
		model.addAttribute("memberLists", memberLists);
		logger.info("memberLists.size() -> {}", memberLists.size());
		
		return "members/memberList";
	}
	

}
