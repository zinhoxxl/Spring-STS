package com.oracle.mvc02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 디스패치서블릿이 사용가능한 컨트롤러라고 선언
@Controller
public class MVC02Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(MVC02Controller.class);
	
	@RequestMapping(value = "/board/view2")
	public String view2() {
		logger.info("Logger board/view2 Start..."); // 관등성명 대주니까 에러추적하기도 편하고 좋은방법
		System.out.println("sysout board/view2"); // 이렇게만 하면 에러발생시 찾기 힘듬
		
		return "board/view2";
	}

}
