package chap04;

public class Calculator {
	
	public int add(int a, int b) {
		return a+b; 
	}
	
	private int add(String a, int b) {
		int a1 = Integer.parseInt(a);
		return a1+b;
	}
	
	private int add(int a, String b) {
		int b1 = Integer.parseInt(b);
		return a+b1;
	}
	
	public int add(String a, String b) {
		int a1 = Integer.parseInt(a);
		int b1 = Integer.parseInt(b); 
		return a1 + b1; 
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		System.out.println(cal.add(10,5));
		System.out.println(cal.add("10","5"));
		System.out.println(cal.add("10",5));
		System.out.println(cal.add(10,"5"));
		
	}
}
