package lab06;

public class AngramTest {
	
	public static void main (String[] args) {
	
	
		 
 	
		
		
		
		//Tester for areAnagrams
		System.out.println("Tester for areAnagrams Method: ");

		System.out.println(AnagramUtil.areAnagrams("being", "Begin")); 
		System.out.println(AnagramUtil.areAnagrams("yes", "No"));
		
		//Tester for sort method
		String sortyy = "ZYXWAbcd";
		System.out.println("Tester for sort method:");
		System.out.println(AnagramUtil.sort(sortyy));
		
		//Tester for getLargestAnagramGroup
		System.out.println("Tester for getLargestAnagramGroup Method: ");
		String[] test = new String[] {"being", "abc", "begkin", "cba", "ingbei"};
		String[] tester = AnagramUtil.getLargestAnagramGroup(test);
		for (String t : tester)
			System.out.println(t);
		
		
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		System.out.println("Tester Method for getLargestAnagramsGroup File:");
		for (String s : s3)
			System.out.println(s);
		
	}

}
