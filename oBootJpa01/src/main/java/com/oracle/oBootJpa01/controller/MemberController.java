package com.oracle.oBootJpa01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.oBootJpa01.domain.Member;
import com.oracle.oBootJpa01.service.MemberService;


@Controller
public class MemberController {
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@GetMapping(value = "/members/new")
	public String createForm() {
		System.out.println("MemberController /Members/new start...");
		return "members/createMemberForm";
	}
	
	
	@PostMapping(value = "/members/save")
	public String create(Member member) {
		System.out.println("MemberController create Start...");
		System.out.println("member.getId() -> " + member.getId());
		System.out.println("member.getName() -> " + member.getName());
		memberService.join(member);
		
		return "redirect:/";
	}
	
	
	@GetMapping(value = "/members")
	public String listMember(Model model) {
		List<Member> memberList = memberService.getListAllMember();
		model.addAttribute("members", memberList);
		return "members/memberList";
	}
	
	
	@PostMapping(value = "/members/search")
	public String search(Member member, Model model) {
		System.out.println("/members/search member.getName() -> " + member.getName());
		List<Member> memberList = memberService.getListSearchMember(member.getName());
		System.out.println("/members/search memberList.size() -> " + memberList.size());
		model.addAttribute("members", memberList);
		return "members/memberList";
	}
	

}
