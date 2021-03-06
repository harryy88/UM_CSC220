package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	
	// constructor 1 - Constructor for new zero matrix
	
	public Matrix(int rowDim, int colDim){
		if (rowDim >= 0 && colDim >= 0) {
			this.numRows = rowDim;
			this.numColumns = colDim;
			data = new int[rowDim][colDim];
			
		}
		else {
			data = new int[1][1];
			
		}
		/*
		* TODO: write a constructor that would create a matrix
		* of correct size and initialize it to 0. 
		*/
		 
	}
	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		numRows = d.length;
		numColumns = d[0].length; 
		if (numRows > 0 && numColumns > 0) {
			data = new int[numRows][numColumns];
			for(int row = 0; row< numRows; row++) {
				for (int col = 0; col < numColumns; col++ ) {
					data[row][col] = d[row][col] ;
				}
			}
		}
		else {
			data = new int[1][1];
			
		}
		/* 1) put the numRows to be the number of 1D arrays in the 2D array
		*  2) specify the numColumns and set it
		*  3) be careful of special cases you are supposed to handle them properly
		*  4) create a new matrix to hold the data
		*  5) copy the data over
		*/
	}	
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		
		String vecy = "\n";
	    for (int row =0; row<numRows; row++){
	      for(int col = 0; col <numColumns; col++){
	        int put = data[row][col];
	        String place = Integer.toString(put); 
	        vecy += place + " "; 
	      }
	      vecy += "\n";
	    }
		/*
		 * TODO: replace the below return statement with the correct code, you must return a String that represents this 
		 * 			matrix, as specified in the instruction for M1 - anything else IS NOT acceptable
		 */
	   
		return vecy; // placeholder		
	}
	
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		if ((m.data.length != data.length) || (m.data[0].length != data[0].length)) {
			return false; 
		}
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++ ) {
				if (m.data[row][col] != data[row][col]) {
					return false; 
				}
			}
		}
		/*
		 * TODO: replace the below return statement with the correct code, you must return the correct value
		 * 			after determining if this matrix is equal to the input matrix
		 */
		return true; // placeholder
	}

	public Matrix times(Matrix m)
	{
		if (numColumns != m.numRows) {
			return null; 
		}
	
		int coly = numRows; 
		int rowy = m.numColumns;
		Matrix mult = new Matrix(coly,rowy);
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < m.numColumns; c++) {
				for (int n = 0; n < numColumns; n++) {
					mult.data[r][c] += data[r][n] * m.data[n][c]; 
				}
				
			}
		}
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for multiplication, if not, return null.
		 *  If they are compatible, determine the dimensions of the resulting matrix, and fill it in with
		 *  the correct values for matrix multiplication
		 */
		return mult; // placeholder
	}
	
	public Matrix plus(Matrix m)
	{
		if ((m.data.length != data.length) || (m.data[0].length != data[0].length)) {
			return null; 
		}
		Matrix addy = new Matrix(m.numRows, m.numColumns); 
		for(int row = 0; row< numRows; row++) {
			for (int col = 0; col < numColumns; col++ ) {
				addy.data[row][col] = data[row][col] + m.data[row][col];
			}
			
		}
		
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for addition, if not, return null.
		 *  If they are compatible, create a new matrix and fill it in with
		 *  the correct values for matrix addition
		 */
		return addy; // placeholder
	}	
}
