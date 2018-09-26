package lab05;

public class Tester {
	public static void main(String args[]) {
		
		double[] boo = new double[] {};
		
		BinarySearchSet yoo = new BinarySearchSet(boo); 
		

		yoo.binary_add(1);
		yoo.binary_add(3);
		yoo.binary_add(6);
		yoo.binary_add(0);
		yoo.binary_add(2);
		yoo.binary_add(0);
	
		
	
		System.out.println(yoo.isEmpty());
		
		
		
	}
}
