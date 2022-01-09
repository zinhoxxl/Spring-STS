package com.oracle.mvc02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
// 디스패치 서블릿이 부를수 있는 컨트롤러
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// 뷰의 요청 경로 지정
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// 로직 수행
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		// Model 객체를 이용해서, Data전달
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; // view파일 리턴
	}
	
	
	@RequestMapping(value = "/board/view")
	public String view() {
		logger.info("Logger board/view Start..."); // 관등성명 대주니까 에러추적하기도 편하고 좋은방법
		System.out.println("sysout board/view"); // 이렇게만 하면 에러발생시 찾기 힘듬
		
		return "board/view";
	}
	
	// 이건 파라미터
	@RequestMapping("/board/content")
	public String content(Model model) {
		System.out.println("content controller sysout board/view");
		
		model.addAttribute("id", 30);
		return "board/content";
	}
	
	// Model and View 매우 중요함!!!  (리턴형, 객체 자체를 리턴!)
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		
		// 데이터와 뷰를 동시에 설정이 가능
		ModelAndView mv = new ModelAndView(); // 객체를 선언 및 생성
		mv.addObject("id", 30); // 뷰로 보낼 데이터 값
		mv.setViewName("board/reply"); // 뷰의 이름
		
		return mv; // 객체 반환
	}
	
	
}
