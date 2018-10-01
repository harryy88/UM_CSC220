package lab06;

public class AngramTest {
	
	public static void main (String[] args) {
	
	
	//	String[] test = new String[] {"being", "abc", "begkin", "cba", "ingbei"}; 
 	
		
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		for (String s : s3)
			System.out.println(s);
	}

}
