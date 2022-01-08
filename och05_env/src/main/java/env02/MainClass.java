package env02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX02.xml");
		
		// AdminConnection클래스를 adminConnection빈으로 설정한 놈을 나는 connection이라는 이름으로 사용하겠다
		AdminConnection connection = ctx.getBean("adminConnection", AdminConnection.class);
		// getter 로 가져오기
		System.out.println("adminID : " + connection.getAdminId());
		System.out.println("adminPW : " + connection.getAdminPw());
	 	System.out.println("sub_adminID : " + connection.getSub_adminId());
		System.out.println("sub_adminPW : " + connection.getSub_adminPw());
		
		// 나는 setter 로 값을 가져오지 않았지만 CTX02.xml에서  값을 setter로 보낸걸 받았기에 
		// admin2.properties, sub_admin2.properties 의 값을 저장해서 불러옴
		
		ctx.close();
	}

}
