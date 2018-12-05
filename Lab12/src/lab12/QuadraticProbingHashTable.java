package lab12;


public class QuadraticProbingHashTable
{
	
    public HashEntry [ ] HashTable;   // The array that holds the hash table
    public int currentSize;       // The number of occupied cells	

	// constructor to create the HashTable of initial size = size
    // and sets all of its elements to null.
    public QuadraticProbingHashTable( int size )
    {
    	// FILL IN
    	HashTable = new HashEntry[size];
    	currentSize = 0; 
    	
    }
 
    // insert into the hash table
    // if the item is already present, do nothing and simply return
    // be careful you might need to rehash - reshape when the load factor is .75
    // Hint: first check the load factor after add - if the size is beyond rehash first!
    public void insert( int x )
    {
    	// CHECK LOAD FACTOR
    	double load = (1.0 + currentSize) / HashTable.length;
    	if ( load >= 0.75) {
    		rehash(); 
    	}
    	int index = hash(x, HashTable.length);
    	HashEntry he = HashTable[index];
    	if (he == null || !he.isActive) {  
    		HashTable[index] = new HashEntry(x); 
    		++currentSize;
    	}
    	else {
    		probe(x, index);
    	}
    	
    
    }

    private void probe(int x, int index) {
    	int quadratic = index; 
    	int count = 0; 
    	HashEntry h = HashTable[quadratic];
		// TODO Auto-generated method stub
    	do {
    		++count; 
    		quadratic = (int) ((index + Math.pow(count, 2)) % HashTable.length);
    		h = HashTable[quadratic];
    	}
//    	while (HashTable[quadratic] != null && HashTable[quadratic].isActive);
    	while ((h != null && h.isActive));
    	HashTable[quadratic] = new HashEntry(x); 
    	++currentSize;
	}

	// this function will increase the size of the hash table by a factor of two
    // and do the rehash of the current elements inside the hash table
    public void rehash( ){
     	int newSize = HashTable.length * 2; 
     	QuadraticProbingHashTable  NewTable = new QuadraticProbingHashTable(newSize); 
    	for (HashEntry h : HashTable) {
    		if (h != null)
    			NewTable.insert(h.element);
    	}
    	this.HashTable = NewTable.HashTable;
    	
    	
    }
    
    // a simple hash function for int values
    // the hash value should be a number between 0 and tableSize-1
    // use the mod operator as suggested in class
    public int hash(int value, int tableSize )
    {
    	// FILL IN - DO NOT RETURN -1
    	value = Math.abs(value);
    	return (value % tableSize); 
    	
    }  
    

    // this function will remove an element from the hash table
    // remember you are not going to remove the element from the hash table (physcially)
    // instead you are supposed to make it inactive
    public void remove( int x ){
    	int index = find(x);
    	if (index == -1)
    		return;
    	HashTable[index].isActive = false;
    	--currentSize;
    }

    // this function finds an element in the hash table
    // x is the value we are looking for
    // This function returns the index in which the value resides
    // if not in the hashtable return -1
    public int find( int x )
    {
    	int index = hash(x, HashTable.length);
    	HashEntry he = HashTable[index];
    	int quadratic = index; 
    	if (he != null && he.isActive && he.element == x) {  
    		return index; 
    	}
    	else {
    		
        	int count = 0; 
    		// TODO Auto-generated method stub
        	do {
        		++count;
        		quadratic = (int) ((index + Math.pow(count, 2)) % HashTable.length);
        		he = HashTable[quadratic];
        		if (he == null || count > HashTable.length)
        			return -1;
        		
        		
        	} while ((he != null) && (he.isActive) && (he.element != x));
    	}
    	return quadratic; 
    	
    }
    
    
    // DO NOT CHNAGE THIS FUNCTION!
    public String toString(){
    	String toReturn = "";
    	for (int i = 0; i < HashTable.length; i++){
    		if (HashTable[i] == null){
    				toReturn += ("eF ");
    		}else{
    			if (HashTable[i].isActive)
    				toReturn += (HashTable[i].element + "T ");
    			else
    				toReturn += (HashTable[i].element + "F ");
    		}
    	}
    	return toReturn;
    }
    
    
    public static void main(String[] args){
    	
    	
    	// ********************* TESTS FOR LAB ****************************//
    	
    	QuadraticProbingHashTable h1 = new QuadraticProbingHashTable(10);
    	
    	if (!h1.toString().equals("eF eF eF eF eF eF eF eF eF eF "))
    		System.err.print("TEST FAILED: constructor ( 0 )");
    	 	
    	h1.insert(89);
    	h1.insert(58);
    	h1.insert(6);
    	
    	if (!h1.toString().equals("eF eF eF eF eF eF 6T eF 58T 89T "))
    		System.err.println("TEST FAILED: insert ( 1 )");
    		
    	h1.insert(16);
 
    	
    	if (!h1.toString().equals("eF eF eF eF eF eF 6T 16T 58T 89T "))
    			System.err.println("TEST FAILED: insert ( 2 )");
    	
    	
    	  
    	h1.insert(9);
    	if (!h1.toString().equals("9T eF eF eF eF eF 6T 16T 58T 89T "))
			System.err.println("TEST FAILED: insert ( 3 )");   
    	
    	QuadraticProbingHashTable h2 = new QuadraticProbingHashTable(7);
    	
    	h2.insert(0);
    	h2.insert(1);
    	h2.insert(2);
    	h2.insert(3);
    	h2.insert(4);
    	h2.insert(5);
    	
    	if (!h2.toString().equals("0T 1T 2T 3T 4T 5T eF eF eF eF eF eF eF eF "))
			System.err.println("TEST FAILED: insert ( 4 )"); 
    	
    
    	
    	System.out.println("Lab Testing Done!!!");
    	
    	
    	// ********************* TESTS FOR ASSIGNMENT ****************************//
    	
    	QuadraticProbingHashTable h3 = new QuadraticProbingHashTable(11);
    	
    	if (!h3.toString().equals("eF eF eF eF eF eF eF eF eF eF eF "))
			System.err.println("TEST FAILED: insert ( 5 )");    	    	
    	
    	h3.insert(44);    	
    	h3.insert(4);
    	h3.remove(44);
    	
    	if (!h3.toString().equals("44F eF eF eF 4T eF eF eF eF eF eF "))
			System.err.println("TEST FAILED: remove ( 6 )");    	    	
    	
    	h3.insert(77);
    	
    	if (!h3.toString().equals("77T eF eF eF 4T eF eF eF eF eF eF "))
			System.err.println("TEST FAILED: insert ( 7 )");    	    	    	
    	 
    	
    	h3.insert(16);  
    	h3.insert(28);
    	h3.insert(21);  
    	h3.insert(11);  
    	h3.insert(22);
    	h3.insert(33); 
   

    	if (!h3.toString().equals("77T 11T eF 33T 4T 16T 28T eF eF 22T 21T "))
			System.err.println("TEST FAILED: insert ( 8 )");  

    
    	h3.insert(55);
    	
    	if (!h3.toString().equals("22T eF eF eF 4T eF 28T eF eF eF eF 77T 11T eF eF 33T 16T eF eF eF 55T 21T "))
			System.err.println("TEST FAILED: insert ( 9 )");  
    	
    


    	if (h3.find(4) != 4)
    		System.err.print("TEST FAILED: find ( 10 )");

    	if (h3.find(44) != -1)
    		System.err.print("TEST FAILED: find ( 11 )");

    
    	if (h3.find(77) != 11)
    		System.err.print("TEST FAILED: find ( 12 )");    
    	
    	System.out.println("Assignment Testing Done!!!");
    	
    }

}