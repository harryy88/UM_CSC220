package lab06;

import java.util.Comparator;


public class OrderStrings implements Comparator <String> {

		public int compare(String o1, String o2) {
			if (o1.compareTo(o2) == 0)
				return 0; 
			
			else if (o1.compareTo(o2) > 0)
				return 1; 
			
			else 
				return -1; 
		}
	
	  }


