package com.oracle.mvc152;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// 검증할 객체의 클래스 타입 정보
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)target;
		
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "이름이 없거나 비어 있습니다");
		}
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}

	}

}
