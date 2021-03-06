package lab01;

public class SumExperiment {
	
	public static int check_sum(int[] array){
		int front = 0; 
		int end = array.length - 1;
		int sum = 0; 
		while (sum != 20) {	
			sum = array[front] + array[end];
			if (front == end) {
				return -1; 
			}
			else if (sum < 20) {
				front += 1; 
			}
			else {
				end -= 1; 
			}
		}
		
		return front;
	}
	
	
	public static void main(String[] args) {

		
		
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (check_sum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (check_sum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (check_sum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (check_sum(array4) != -1)
			System.err.println("TEST4 FAILED");
	
		
		System.out.println("Done!!!");
	}
}
