package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;




public class AnagramUtil {
	
	
	public static String sort(String inputString) {
		/*
		-This method returns the sorted version of the input string.
		-The sorting must be accomplished using an insertion sort
		-We do not care about lower/upper case.
		*/
		if (inputString == null || inputString.isEmpty()  ) {
			return null; 
		}
		
		 String[] arr = inputString.toLowerCase().split("");
		
		 int n = arr.length;
	     for (int i=1; i<n; ++i) {
	    	 String key = arr[i];
	         int j = i-1;
	         while (j>=0 && arr[j].compareTo(key) > 0) {
	        	 arr[j+1] = arr[j];
	             j = j-1;
	         }
	         arr[j+1] = key;
	        }
	
	        return Arrays.toString(arr); 
	      
	}
	
	
	public static boolean areAnagrams(String string1, String string2) {
		/*
		-This method returns true if the two input strings are anagrams of
		each other, otherwise returns false.
		- To check if two words are anagrams, simply sort the characters in
		each word. If the sorted versions are the same, the words are anagrams of each other
		*/
		if (string1.length() == 0 || string1.length() == 0) {	return false; }
		if (sort(string1).equals(sort(string2)) ) {
			return true; 
		}
		
		return false; 
	}
	
	public static void insertionSort(String[] inputList) {
		
		OrderStrings c = new OrderStrings(); 
		
		 int n = inputList.length;
	     for (int i=1; i<n; ++i) {
	    	 String key = inputList[i];
	         int j = i-1;
	         while (j>=0 && c.compare(sort(inputList[j]), sort(key))  > 0) {
	        	 inputList[j+1] = inputList[j];
	             j = j-1;
	         }
	         inputList[j+1] = key;
	        }
		
		
	}
	
	public static String[] getLargestAnagramGroup(String[]inputList){
		if ( inputList.length == 0 ) {	return new String[1]; }
		insertionSort(inputList);
		int max = -999, index = 0, lrg = 0; 
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : inputList) {
			Integer fq =  (map.get(sort(s)));
			int val = fq == null ? 1 : fq + 1;  
			map.put(sort(s), val);	
			if (val > max) {	
				max = val; 
				lrg = index; 
				}
			++index; 
		}
		
		String[] largest = new String[max]; 
		if (max == 1) {		return new String[max]; }
		for (int i = 0 ; i < max ; i++) {
			largest[i] = inputList[lrg - i  ];
		}
	
		return largest;
		
	}
	
	public static String[] getLargestAnagramGroup(String filename) {
		String[] group = readFile(filename);
		return getLargestAnagramGroup(group);
	}
	
	
	// Reads words from a file (assumed to contain one word per line)
	// Returns the words as an array of strings.
	public static String[] readFile(String filename)
	{
		ArrayList<String> results = new ArrayList<String>();
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(filename));
			while(input.ready())
			{
				results.add(input.readLine());
			}
			input.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
		String[] retval = new String[1];
		return results.toArray(retval);
	}	

	
	
	
	
	

}
