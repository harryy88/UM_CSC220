package lab09;

public class IntTreeTester {
	public static void main(String[] args){
		
		
		// Example trees
		// Use PrintSideways to get a sense of the tree structures (and consult the instruction)
		IntTree empty_tree = new IntTree(0);
		IntTree tree1 = new IntTree(1);
		IntTree tree2 = new IntTree(2);
		IntTree tree3 = new IntTree(3);
		IntTree tree4 = new IntTree(4);
		IntTree tree6 = new IntTree(6);
				
		int[] arr1 = {3, 5, 2, 1, -1, 4, 6};
		IntTree tree_ref1 = new IntTree(arr1);
		
		int[] arr2 = {2, 8, 1, 0, -1, 7, 6, -1, -1, -1, -1, 4, -1, -1, 9};
		IntTree tree_ref2 = new IntTree(arr2);
		
		// ********************* TESTS FOR LAB ****************************//
		
		// *** countEmpty() tests
		int n0 = empty_tree.countEmpty();
		if (n0 != 1)
			System.err.println("TEST FAILED: countEmpty() with empty tree");

		int n1 = tree1.countEmpty();
		if (n1 != 2)
			System.err.println("TEST FAILED: countEmpty() with tree1");

		int n2 = tree2.countEmpty();
		if (n2 != 3)
			System.err.println("TEST FAILED: countEmpty() with tree2");

		int n3 = tree3.countEmpty();
		if (n3 != 4)
			System.err.println("TEST FAILED: countEmpty() with tree3");		
		
		int n4 = tree4.countEmpty();
		if (n4 != 5)
			System.err.println("TEST FAILED: countEmpty() with tree4");				

		int n6 = tree6.countEmpty();
		if (n6 != 7)
			System.err.println("TEST FAILED: countEmpty() with tree6");						

		int n_ref1 = tree_ref1.countEmpty();
		if (n_ref1 != 7)
			System.err.println("TEST FAILED: countEmpty() with tree_ref1");						

		int n_ref2 = tree_ref2.countEmpty();
		if (n_ref2 != 9)
			System.err.println("TEST FAILED: countEmpty() with tree_ref2");
		
		// *** printLevel tests
		if (!empty_tree.getLevel(1).equals(""))
			System.err.println("TEST 1 FAILED: getLevel() with empty tree");
		
		if (!tree_ref2.getLevel(1).equals("2\n"))
			System.err.println("TEST 2 FAILED: getLevel() with tree_ref2");
		
		if (!tree_ref2.getLevel(2).equals("8\n1\n"))
			System.err.println("TEST 3 FAILED: getLevel() with tree_ref2");	


		if (!tree_ref2.getLevel(3).equals("0\n7\n6\n"))
			System.err.println("TEST 4 FAILED: getLevel() with tree_ref2");
		
		if (!tree_ref2.getLevel(4).equals("4\n9\n"))
			System.err.println("TEST 5 FAILED: getLevel() with tree_ref2");
		
		if (!tree_ref2.getLevel(5).equals(""))
			System.err.println("TEST 6 FAILED: getLevel() with tree_ref2");
         
         System.out.println("Testing done!!!");
		
		
		
		// ********************* TESTS FOR ASSIGNMENT ****************************//
		
		// *** toString() tests
		if (!empty_tree.toString().equals(""))
			System.err.println("TEST 1 FAILED: toString() with empty tree");
		
		if (!tree2.toString().equals("(1, 2, empty)"))
			System.err.println("TEST 2 FAILED: toString() with tree2");
		
		
		if (!tree3.toString().equals("(1, 2, 3)"))
			System.err.println("TEST 3 FAILED: toString() with tree3");
		
		
		if (!tree4.toString().equals("(1, (2, 4, empty), 3)"))
			System.err.println("TEST 4 FAILED: toString() with tree4");
		
		if (!tree6.toString().equals("(1, (2, 4, 5), (3, 6, empty))"))
			System.err.println("TEST 5 FAILED: toString() with tree6");
	
		
		if (!tree_ref2.toString().equals("(2, (8, 0, empty), (1, (7, 4, empty), (6, empty, 9)))"))
			System.err.println("TEST 5 FAILED: toString() with tree6");
		
		 System.out.println("Testing done!!!");
			
		// *** makePerfect() tests
		empty_tree.makePerfect();
		if (!empty_tree.getInorder().equals(""))
			System.err.println("TEST 1 FAILED: makePerfect() with empty tree");

		tree1.makePerfect();
		if (!tree1.getInorder().equals(" 1 "))
			System.err.println("TEST 2 FAILED: makePerfect() with tree1");
		
		tree2.makePerfect();
		if (!tree2.getInorder().equals(" 2  1  0 "))
			System.err.println("TEST 3 FAILED: makePerfect() with tree2");

		tree3.makePerfect();
		if (!tree3.getInorder().equals(" 2  1  3 "))
			System.err.println("TEST 4 FAILED: makePerfect() with tree3");	
	
		System.out.println("Testing done!!!");
		
		tree4.makePerfect();
		if (!tree4.getInorder().equals(" 4  2  0  1  0  3  0 "))
			System.err.println("TEST 5 FAILED: makePerfect() with tree4");				
		
		tree6.makePerfect();
		if (!tree6.getInorder().equals(" 4  2  5  1  6  3  0 "))
			System.err.println("TEST 6 FAILED: makePerfect() with tree6");						
		
		tree_ref1.makePerfect();
		if (!tree_ref1.getInorder().equals(" 1  5  0  3  4  2  6 "))
			System.err.println("TEST 7 FAILED: makePerfect() with tree_ref1");						
		
		tree_ref2.makePerfect();
		if (!tree_ref2.getInorder().equals(" 0  0  0  8  0  0  0  2  4  7  0  1  0  6  9 "))
			System.err.println("TEST 8 FAILED: makePerfect() with tree_ref2");
         
         System.out.println("Testing done!!!");
		
		

	}
}
