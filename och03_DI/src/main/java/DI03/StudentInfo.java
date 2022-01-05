package DI03;

public class StudentInfo {
	private Student student;
	public StudentInfo(Student student) {
		this.student = student;
	}
	public void getStudentInfo() {
		if(student != null) {
			System.out.println("이름 : " + student.getName());
			System.out.println("나이 : " + student.getAge());
			System.out.println("학번 : " + student.getGradeNum());
			System.out.println("반 : " + student.getClassNum());
			System.out.println("===============================");
		}
	}
	
	// getter / setter
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
