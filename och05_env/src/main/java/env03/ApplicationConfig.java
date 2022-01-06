package env03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig { //XML역할
	
	@Value("${admin.id}") //EL표기법, 요게
	private String adminId; //요기로 들어가
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String sub_adminId;
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	// 환경 파일 잡을때 사용하는 객체 PropertySourcesPlaceholderConfigurer
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() { 
	   PropertySourcesPlaceholderConfigurer configurer 
	                     = new PropertySourcesPlaceholderConfigurer();
	   System.out.println("2. Properties Run");
	   Resource[] locations = new Resource[2];
	   locations[0] = new ClassPathResource("admin3.properties");
	   locations[1] = new ClassPathResource("sub_admin3.properties");
	   // <context:property-placeholder location="classpath:admin2.properties, classpath:sub_admin2.properties" />
	   // 위에는 이거랑 똑같은겨 (import)
	   
	   // System.out.println("PropertySourcesPlaceholderConfigurer1 adminId -> " + adminId);
	   configurer.setLocations(locations);
	   
      return configurer;
	}
	
	@Bean
	public AdminConnection adminConfig() {
		AdminConnection adminConnection = new AdminConnection();
		System.out.println("3. adminConfig Run");
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		
		return adminConnection;
	}
	
}
