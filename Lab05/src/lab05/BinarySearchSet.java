package lab05;

public class BinarySearchSet {

	public double[] storage; //represent the simple array that holds the list values
	private int capacity; //holds the length of the storage array
	private int numItems; //holds the number of the elements/values in the list
	
	
	public BinarySearchSet() {
		//This constructor will create a storage array of size 6 (an initial size for an empty list)
		//and set the rest of the field members accordingly
		storage = new double[6];
		capacity = 6;
		numItems = 0; 
	}
	public boolean isEmpty() {
		//returns true only if this list contains no element
		return (numItems == 0); 
		
	}
	public int size() {
		return numItems; 
	}
	public void grow() {
		//this function double the size of the storage array and modifies
		//other fields accordingly.
		double[] temp = new double[capacity * 2];
		for (int i = 0; i < storage.length; i++) {
			temp[i] = storage[i];
		}
		storage = temp; 
		capacity *= 2; 
	}
	public String toString() {
		//this method will print the elements of the list, its capacity,
		//and its current size (numItems).
		String s = "Capacity = " + capacity + " \nElements = " + numItems + "\nElements = ";
		for (double el : storage) {
			s += el + ", ";
		}
		return s; 
	}
	public boolean remove(double value) {
		 
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == value) {
				double[] temp = new double[capacity - 1];
				for (int j = 0; j < i; j++) {
					temp[j] = storage[j];
				}
				for (int k = i + 1; k < temp.length; k++) {
					temp[k-1] = storage[k];
				}
				temp[temp.length-1] = storage[storage.length-1];
				storage = temp; 
				--capacity; 
				numItems = numItems == 0 ? 0 : numItems-1 ; 
			
				return true; 
			}
		}
		
		return false; //implement
	}
	public boolean sequential_add(double newVal) {
		/*		
		*if this list does not contain the newVal, add it to the correct
		position of the list and return true
		
		*remember that the list is required to be sorted at all times –
		that specifies the correct position for the newVal
		
		*returns false, if the list already includes the value
		
		*use a sequential search in this phase (you will write an
		efficient add for your assignment)
		
		*be careful about what states need to be changed after the remove 
		*/
//		double[] t = new double[] {1,3,5,7,9,0};
//		storage = t; 
//		numItems = 5; 
//		
		for (int i = 0; i < numItems; i++) {
			if (storage[i] == newVal) {
				return false; 
			}
		}
		
		if (capacity == numItems){ grow();  }
		
		if (numItems == 0) { 
			storage[0] = newVal; 
			numItems++; 
			return true; 
		}
		if (numItems == 1) {
			if (storage[0] > newVal) {
				storage[1] = storage[0];
				storage[0] = newVal;
			}
			else {
				storage[1] = newVal;
			}
			numItems++; 
			return true;
		}
		
		int lower = 0; 
		if (newVal < storage[lower]) {
			double[] temp = new double[capacity];
			temp[0] = newVal; 
			for (int j = 1; j < numItems; j++) {
				temp[j] = storage[j-1];	
			}
			storage = temp;
			numItems += 1; 
			return true;  
		}
	
		while (lower <= numItems -1 ) {
			
			if (storage[lower] < newVal && storage[lower+1] > newVal) {
				double[] temp = new double[capacity];
				for (int i = 0; i <= lower; i++) {
					temp[i] = storage[i];
				}
				temp[lower+1] = newVal; 
				for (int j = lower + 2; j < capacity; j++) {
					temp[j] = storage[j-1];
				}
				numItems++; 
				storage = temp; 
				return true; 
			}
			else {
			
				lower++; 
				
			}
			
		}
		
		storage[numItems - 1] = newVal; 
		numItems += 1;
		 
		return true; //implement
	}
	
	public boolean contains(double value) {
//	- this function returns true if this list contains the value
//	- otherwise, it returns false
//	- the contains method must take advantage of the list being sorted
//		and use a binary search to determine if an item is in the array.
		int min = 0; 
		int max = numItems - 1; 
		int mid; 
		while (min <= max) {
			mid = (min + max) / 2;
			if (storage[mid] == value) {
				return true; 
			}
			else if (storage[mid] > value) {
				max = mid -1;
			}
			else {
				min = mid + 1; 
			}
		}
		return false; 
		
	}
	
	public boolean containsAll(double[] elements) {
//	- this function returns true if all the input values (stored in
//		elements) are in the list
//	- otherwise, return false
//	- this method must take advantage of the list being sorted and use
//		a binary search to determine if an item is in the array.
		for (double el : elements) {
			if ( !this.contains(el)) {
				return false; 
			}
		}
		
		return true; 
	}
	
	public BinarySearchSet(double[] input) {
	/* 
	
	array and create an object of BinarySearchSet that includes the
	values in the input array
	- Be careful of the following cases
	- the input might have duplicates (remember your list is not
	allowed to contain duplicates)
	- the input might not be sorted. Hint: think whether you can
	reuse any of the methods you have implemented to make your
	job easier.
	*/
		storage = new double[input.length];
		capacity = input.length;
		numItems = 0; 
		for (double d : input) {
			sequential_add(d);
		}
		
		
	}
	
	public void clear() {
		/* Removes all the elements from the list. The list will be empty
		after this call returns.
		 */
		for (int i = 0; i < capacity; i++) {
			storage[i] = 0; 
		}
		numItems = 0; 
	}
	
}
