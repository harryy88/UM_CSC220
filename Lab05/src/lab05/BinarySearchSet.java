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
		 
		for (int i = 0; i < numItems; i++) {
			if (storage[i] == value && capacity > 1) {
				double[] temp = new double[capacity - 1];
				for (int j = 0; j < i; j++) {
					temp[j] = storage[j];
				}
				for (int k = i + 1; k < numItems; k++) {
					temp[k-1] = storage[k];
				}
				//temp[temp.length-1] = storage[storage.length-1];
				storage = temp; 
				--capacity;
				--numItems; 
				
			
				return true; 
			}
			if (storage[i] == value && capacity == 1) {
				storage = new double[1];
				capacity = 1; 
				numItems = 0; 
			}
		}
		
		return false; //implement
	}
	public boolean sequential_add(double newVal) {
		/*		
		*if this list does not contain  newVal, add to  correct
		position of the list and return true
		
		*list is required to be sorted at all times –
		
		*returns false, if the list already includes the value
		
		*use a sequential search in this phase 

		*/	
		
		if (numItems == 0) { 
			add(newVal, 0);
			return true; 
		}
	
		
		int lower = 0; 
		while (lower < numItems ) {
			if (newVal < storage[lower]) {
				add(newVal, lower);
				return true; 
			}
			++lower; 
	
		}
		add(newVal, numItems);
		return true; 
	
	}
	
	
	public void add(double value, int index) {
		
		for (int i = 0; i < numItems; i++) {
			if (storage[i] == value) {
				return; 
			}
		}
		
		if (capacity == numItems)	{ grow();  }
		
		double[] temp = new double[capacity];
		
		for (int i = 0; i < index; i++) {
			temp[i] = storage[i];
		}
		temp[index] = value; 
		
		for (int j = index; j < numItems; j++){
			temp[j + 1] = storage[j];
		}
		storage = temp; 
		++numItems; 
		return; 
		
	}
	
	
	public boolean binary_add(double newVal) {
		
		//implement
		int min = 0, mid,  max = numItems;
		if (numItems == 0) { 
			add(newVal, 0);
			return true; 
		}
		if (newVal < storage[min])	{ 
			add(newVal, min);
			return true; 
		}
		if (newVal > storage[max -1 ])	{
			add(newVal, max);
			return true; 
		}
		
		while (min <= max) {
			mid = (min + max) / 2; 
			if (newVal > storage[mid]) {
				if (newVal > storage[mid + 1]) {
					min = mid; 
				}
				else {
					add(newVal, mid + 1);
					return true; 
				}
			}
			else {   //newVal <= storage[mid]
				if (newVal < storage[mid -1]) {
					max = mid; 
				}
				else {
					add(newVal, mid);
					return true; 
				}
			}
		
		}
		return false; 
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
			if ( !this.contains(el)) {  //this calls contains which implements the binary search to find 
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
	*/if (input.length > 0) {
		storage = new double[input.length];
		capacity = input.length;
		numItems = 0; 
		for (double d : input) {
			sequential_add(d);
		}
	  }
	else {
		storage = new double[6];
		capacity = 6;
		numItems = 0;
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
