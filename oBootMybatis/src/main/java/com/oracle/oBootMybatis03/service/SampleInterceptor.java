package com.oracle.oBootMybatis03.service;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class SampleInterceptor implements HandlerInterceptor{
	public SampleInterceptor() {
	}
	// 3번
	@Override
	public void postHandle(HttpServletRequest  request,
						   HttpServletResponse response,
						   Object			   handler,
						   ModelAndView modelAndView) throws Exception
	{
		System.out.println("post handle........................");
		String ID = (String)modelAndView.getModel().get("id");
		int memCnt = (Integer)modelAndView.getModel().get("memCnt");
		System.out.println("SampleInterceptor post handle memCnt : " + memCnt);
		if(memCnt < 1) {
			System.out.println("memCnt Not exists");
			request.getSession().setAttribute("ID", ID);
			// User 가 존재하지 않으면 User interCeptor Page(회원등록) 이동
			response.sendRedirect("doMemberWrite");
		} else {            // 정상 Login   User
			System.out.println("memCnt exists");
			request.getSession().setAttribute("ID", ID);
			// User 가 존재하면 User interCeptor Page(회원List) 이동
			response.sendRedirect("doMemberList");
		}
	}
	// 1번
	@Override
	public boolean preHandle(HttpServletRequest  request,
							 HttpServletResponse response,
							 Object handler) throws Exception
	{
		System.out.println("pre handle.......................");
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		// 관등 성명
		System.out.println("Bean : " + method.getBean());
		System.out.println("Method : " + methodObj);
		return true; // 어디서 시작한지 알아보는 거니까 true 해주자
	}

}
