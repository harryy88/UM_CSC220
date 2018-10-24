package lab08;

public class LinkedIntListTester {
	
	public static void main(String[] args){

		
		double []gradePoint = {0,0,0,0};
	    double []givenPoint = {16,16,16,16};
	    String output = "";
		try{
			
				
			// *** testing lastIndexof	
			int[] arr1 = {1, 18, 2, 7, 18, 39, 18, 40};
			LinkedIntList list1 = new LinkedIntList(arr1);
			
			if (list1.lastIndexOf(18) != 6)
				output+="TEST FAILED -- lastIndexOf when  18 is before the last value\n";	
			else
				gradePoint[0]+=100.0/6.0;
			
			int[] arr2 = {1, 18, 2, 7, 18, 18, 39, 18, 40, 18};
			LinkedIntList list2 = new LinkedIntList(arr2);
			
			if (list2.lastIndexOf(18) != 9)
				output+="TEST FAILED -- lastIndexOf when 18 is last value\n";
			else
				gradePoint[0]+=100.0/6.0;
					
			if (list2.lastIndexOf(7) != 3)
				output+="TEST FAILED -- lastIndexOf when 7 is the only value present in the list\n";
			else
				gradePoint[0]+=100.0/6.0;
					
			if (list2.lastIndexOf(36) != -1)
				output+="TEST FAILED -- lastIndexOf when 36 doesn't belongs to the list\n";
			else
				gradePoint[0]+=100.0/6.0;
			
			if (list2.lastIndexOf(1) != 0)
				output+="TEST FAILED -- lastIndexOf when 1 is the first value of the list\n";
			else
				gradePoint[0]+=100.0/6.0;
			
			
			LinkedIntList list = new LinkedIntList();
				
			if (list.lastIndexOf(3) != -1)
				output+="TEST FAILED -- lastIndexOf  with empty list\n";
			else
				gradePoint[0]+=100.0/6.0;
			
			
			// remove all testing
			
			
			int[] arr3 = {9, 4, 2, 3, 8, 17, 4, 18};
			LinkedIntList list3 = new LinkedIntList(arr3);
			list3.removeAll(3);
			
			if (!list3.toString().equals("[9, 4, 2, 8, 17, 4, 18]"))
				output+="TEST FAILED -- removeAll when tried to remove only one 3.\n";
			else
				gradePoint[1]+=100.0/6.0;
			
			int[] arr4 = {9, 4, 2, 3, 3, 8, 17, 4, 18};
			LinkedIntList list4 = new LinkedIntList(arr4);
			list4.removeAll(3);
			
			if (!list4.toString().equals("[9, 4, 2, 8, 17, 4, 18]"))
				output+="TEST FAILED -- removeAll when tried remove 2 consecutive 3's.\n";
			else
				gradePoint[1]+=100.0/6.0;
	
			int[] arr5 = {3, 9, 4, 2, 3, 3, 8, 17, 4, 18};
			LinkedIntList list5 = new LinkedIntList(arr5);
			list5.removeAll(3);
			
			if (!list5.toString().equals("[9, 4, 2, 8, 17, 4, 18]"))
				output+="TEST FAILED -- removeAll when 3 is present in the first location and middle.\n";
			else
				gradePoint[1]+=100.0/6.0;
			
			int[] arr6 = {3, 9, 4, 2, 3, 3, 8, 17, 4, 18, 3};
			LinkedIntList list6 = new LinkedIntList(arr6);
			list6.removeAll(3);
			
			if (!list6.toString().equals("[9, 4, 2, 8, 17, 4, 18]"))
				output+="TEST FAILED -- removeAll when 3 is present in the first, last, and in the middle locations.\n";
			else
				gradePoint[1]+=100.0/6.0;
			
			list6.removeAll(333);
			
			if (!list6.toString().equals("[9, 4, 2, 8, 17, 4, 18]"))
				output+="TEST FAILED -- removeAll when 333 is not present in the list\n";
			else
				gradePoint[1]+=100.0/6.0;
				
	
			int[] arr33 = {};
			LinkedIntList list33 = new LinkedIntList(arr33);
			list33.removeAll(3);
			
			if (!list33.toString().equals("[]"))
				output+="TEST FAILED -- removeAll when tried to remove from empty list.\n";
			else
				gradePoint[1]+=100.0/6.0;
			
			// ********************* TESTS FOR ASSIGNMENT ****************************//
			
			// *** testing stutter
			
			
			int[] arr8 = {1};
			LinkedIntList list8 = new LinkedIntList(arr8);
			list8.stutter();
	
			if (!list8.toString().equals("[1, 1]"))
				output+="TEST FAILED -- stutter when only 1 value was present before the call.\n";
			else
				gradePoint[2]+=100.0/4.0;
			
			int[] arr9 = {1, 8};
			LinkedIntList list9 = new LinkedIntList(arr9);
			list9.stutter();
	
			if (!list9.toString().equals("[1, 1, 8, 8]"))
				output+="TEST FAILED -- stutter when 2 values were present before the call\n";
			else
				gradePoint[2]+=100.0/4.0;
			
			int[] arr10 = {1, 8, 19, 4, 17};
			LinkedIntList list10 = new LinkedIntList(arr10);
			list10.stutter();
	
			if (!list10.toString().equals("[1, 1, 8, 8, 19, 19, 4, 4, 17, 17]"))
				output+="TEST FAILED -- stutter when 5 values where present before the call\n";
			else
				gradePoint[2]+=100.0/4.0;
			
			
			int[] arr7 = {};
			LinkedIntList list7 = new LinkedIntList(arr7);
			list7.stutter();
	
			if (!list7.toString().equals("[]"))
				output+="TEST FAILED -- stutter with empty list\n";
			else
				gradePoint[2]+=100.0/4.0;
			
			
			// *** testing shift
					
			
			int[] arr12 = {1, 2, 3};
			LinkedIntList list12 = new LinkedIntList(arr12);
			list12.shift();
			
			if (!list12.toString().equals("[1, 3, 2]"))
				output+="TEST FAILED -- shift when there is only 3 elements in the list\n";
			else
				gradePoint[3]+=100.0/5.0;
			
			int[] arr13 = {1,2};
			LinkedIntList list13 = new LinkedIntList(arr13);
			list13.shift();
			
			if (!list13.toString().equals("[1, 2]"))
				output+="TEST FAILED -- shift when there is only 2 elements in the list\n";
			else
				gradePoint[3]+=100.0/5.0;
			
			int[] arr14 = {10, 31, 42, 23, 44, 75, 86};
			LinkedIntList list14 = new LinkedIntList(arr14);
			list14.shift();
			
			if (!list14.toString().equals("[10, 42, 44, 86, 31, 23, 75]"))
				output+="TEST FAILED -- shift when there is 7 elements in the list\n";
			else
				gradePoint[3]+=100.0/5.0;
			
			
			int[] arr144 = {10};
			LinkedIntList list144 = new LinkedIntList(arr144);
			list144.shift();
			
			if (!list144.toString().equals("[10]"))
				output+="TEST FAILED -- shift when there is only 1 elment in the list\n";
			else
				gradePoint[3]+=100.0/5.0;
			
			
			int[] arr11 = {};
			LinkedIntList list11 = new LinkedIntList(arr11);
			list11.shift();
			
			if (!list11.toString().equals("[]"))
				output+="TEST FAILED -- shift when list is empty\n";	
			else
				gradePoint[3]+=100.0/5.0;
		
		}catch(Exception ex){
			int endLen = ex.toString().length()<50?ex.toString().length():50;
			output+="Your program had major Exception when running!.\n"+ex.toString().substring(0, endLen);
		}
		
		arrayTestPrint(gradePoint,givenPoint);
	    System.out.println(output);
	}
	
	public static void arrayTestPrint(double []arr,double []givenpoint){
		  System.out.print("$$");
		  int i=0;
		  for(double r: arr){
			  //System.out.println(givenpoint[i]);
			  System.out.print(Math.round((r*givenpoint[i])/100.0));
			  System.out.print("$$");
			  i++;
		  }
	  }
		
	}

