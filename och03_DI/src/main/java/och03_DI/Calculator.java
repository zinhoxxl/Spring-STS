package och03_DI;

public class Calculator {
	public void addition(int f , int s) { //call by Value
		System.out.println("addition()");
		int result = f + s;
		System.out.println(f + " + " + s + " = " + result);
	}
	public void subtraction(int f , int s) { //call by Value
		System.out.println("subtraction()");
		int result = f - s;
		System.out.println(f + " - " + s + " = " + result);
	}
	public void multiplication(int f , int s) { //call by Value
		System.out.println("multiplication()");
		int result = f * s;
		System.out.println(f + " * " + s + " = " + result);
	}
	public void division(int f , int s) { //call by Value
		System.out.println("division()");
		int result = f / s;
		System.out.println(f + " / " + s + "=" + result);
	}

}
