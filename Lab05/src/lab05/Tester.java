package lab05;

public class Tester {
	public static void main(String args[]) {
		
		double[] boo = new double[]{5,9,2,3,21,18,49, 21};
		
		BinarySearchSet yoo = new BinarySearchSet(boo); 
		//System.out.println(yoo.contains(21));
		
//		yoo.sequential_add(5); 
	//	yoo.sequential_add(21); 
		//yoo.sequential_add(21);
		
//		yoo.sequential_add(21);
//		yoo.sequential_add(21); 
		//yoo.sequential_add(21); 
		//yoo.sequential_add(96);
//		yoo.sequential_add(2);
		System.out.println(yoo.toString());
		yoo.clear();
		System.out.println(yoo.toString());
		
		
		
	}
}
