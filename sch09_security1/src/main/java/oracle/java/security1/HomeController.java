package oracle.java.security1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/login.html") // 경로 입력하면 중간에 시큐리티가 가로채서 검증 들어감
	public String login(Model model) {
		System.out.println("login Start..."); // 검증에서 로그인 성공하면 메시지 출력
		return "security/login";
	}
/*	public String login(Locale locale, Model model) {
		return "security/login";
	}*/
	@RequestMapping("/welcome.html") // user로 접근 시도하면 403(금지됨)에러 발생
	public String welcome(Model model) {
		System.out.println("welcome Start...");
		return "security/welcome";
	}
	
}
