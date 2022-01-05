package sdlc01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
	private String name;
	private int age;

	public void destroy() throws Exception {
		System.out.println("Student의 destroy() --> 소멸자가 소멸되기 전...");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Student afterPropertiesSet --> 생성자 생성 이후");
	}

	// 생성자
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//getter / setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
