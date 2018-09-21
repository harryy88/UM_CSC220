package lab05;

public class Tester {
	public static void main(String args[]) {
		
		double[] boo = new double[] {3,6};
		
		BinarySearchSet yoo = new BinarySearchSet(boo); 
		
		yoo.binary_add(7);
		yoo.binary_add(7);
		yoo.binary_add(.7);
		yoo.binary_add(12);
		yoo.binary_add(949);
		yoo.binary_add(867);
		yoo.remove(949);
		yoo.binary_add(950);
		
		yoo.sequential_add(97);
		System.out.println(yoo.contains(12));
	
		System.out.println(yoo.toString());
		
		
		
	}
}
