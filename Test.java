package ceng.estu;
public class Test {
	/*******************************************************
	 * Test1
	 *******************************************************/
	public static int Test1(){
		AVL avl = new AVL();
		AVLNode node;
		int depth;

		// Insert keys
		avl.Insert(10);
		avl.Insert(5);
		avl.Insert(15);
		avl.Insert(15);
		avl.Insert(5);
		avl.Insert(5);

		// Print the AVL on the screen
		depth = avl.Depth();
		System.out.print("Depth of the tree is: " + depth + "\n");
		avl.Print();

		node = avl.Root();
		if (node.key != 10 || node.count != 1) return 0;

		node = avl.Root().left;
		if (node.key != 5 || node.count != 3) return 0;

		node = avl.Root().right;
		if (node.key != 15 || node.count != 2) return 0;

		return 30;
	} //end-Test1

	/*******************************************************
	 * Test2
	 *******************************************************/
	public static int Test2(){
		AVL avl = new AVL();
		AVLNode node;
		int depth, noOfNodes;

		// Insert keys
		avl.Insert(5);
		avl.Insert(5);
		avl.Insert(10);
		avl.Insert(10);
		avl.Insert(1);
		avl.Insert(3);
		avl.Insert(2);
		avl.Insert(4);
		avl.Insert(20);
		avl.Insert(15);
		avl.Insert(30);
		avl.Insert(40);

		// Print the AVL on the screen
		depth = avl.Depth();
		noOfNodes = avl.NoOfNodes();
		if (depth != 3) return 0;
		if (noOfNodes != 10) return 0;

		System.out.print("Tree Depth: " + depth + ", NoOfNodes: " + noOfNodes + "\n"); 
		avl.Print();

		node = avl.Min();
		if (node.key != 1 || node.left != null) return 0;

		node = avl.Max();
		if (node.key != 40 || node.right != null) return 0;

		// Check the validity of the tree
		node = avl.Root();
		if (node.key != 5 || node.count != 2) return 0;

		node = avl.Root().left;
		if (node.key != 3 || node.count != 1) return 0;

		node = avl.Root().left.left;
		if (node.key != 1 || node.count != 1) return 0;

		node = avl.Root().left.right.left;
		if (node.key != 4 || node.count != 1) return 0;

		node = avl.Root().left.left.right;
		if (node.key != 2  || node.count != 1) return 0;

		node = avl.Root().right;
		if (node.key != 20  || node.count != 1) return 0;

		node = avl.Root().right.right;
		if (node.key != 30 || node.count != 1) return 0;

		node = avl.Root().right.right.right;
		if (node.key != 40  || node.count != 1) return 0;

		node = avl.Root().right.left;
		if (node.key != 10 || node.count != 2) return 0;

		node = avl.Root().right.left.right;
		if (node.key != 15  || node.count != 1) return 0;

		// Test AVLFind
		node = avl.Find(17);
		if (node != null) return 0;

		node = avl.Find(15);
		if (node.key != 15 || node.count != 1) return 0;

		return 30;
	} //end-Test2

	/*******************************************************
	 * Test3
	 *******************************************************/
	public static int Test3(){
		AVL avl = new AVL();
		AVLNode node;

		// Insert keys
		avl.Insert(5);
		avl.Insert(5);
		avl.Insert(10);
		avl.Insert(10);
		avl.Insert(1);
		avl.Insert(3);
		avl.Insert(2);
		avl.Insert(4);
		avl.Insert(20);
		avl.Insert(15);
		avl.Insert(12);
		avl.Insert(11);
		avl.Insert(13);
		avl.Insert(17);
		avl.Insert(16);
		avl.Insert(18);
		avl.Insert(30);

		// Test delete
		if (avl.Delete(35) == 0) return 0;

		// Delete leaf node
		if (avl.Delete(30)!=0) return 0;
		node = avl.Find(20);
		if (node.right!=null && node.left.key!=18) return 0;

		// Delete internal node with only a right subtree
		avl.Delete(1);
		node = avl.Find(3);
		if (node.left.key != 2 && node.right.key != 5) 
			return 0;

		// Delete internal node with only a left subtree
		avl.Delete(5);
		node = avl.Find(3);
		if (node.left.key != 2  && node.right.key != 4) return 0;

		// Delete an internal node with 2 children
		avl.Delete(15);
		node = avl.Find(13);   
		if (node.right.key != 16) return 0;

		// Delete an internal node with 2 children (root)
		avl.Delete(12);
		node = avl.Root();
		if (node.key != 11) return 0;
		if (avl.NoOfNodes()!=11) return 0;

		avl.Print();

		return 30;
	} //end-Test3

	/*******************************************************
	 * Test4
	 *******************************************************/


	/*******************************************************
	 * Main Function
	 *******************************************************/
	public static void main(String args[]){
		int grade = 0;

		System.out.print("---------------------------------- TEST1 ---------------------------\n");
		grade += Test1();
		System.out.print("Your grade after Test1: " + grade + "\n");

		System.out.print("---------------------------------- TEST2 ---------------------------\n");
		grade += Test2();
		System.out.print("Your grade after Test2: " + grade + "\n");

		System.out.print("---------------------------------- TEST3 ---------------------------\n");
		grade += Test3();
		System.out.print("Your grade after Test3: " + grade + "\n");


		System.out.print("--------------------------------------------------------------------\n");
		System.out.print("!=!=!=!=!=!=> Your project grade is: " + grade + "\n");
	} /* end-main */
};

