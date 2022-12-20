package Question2;
//-----------------------------------------------------
//Title: Main Class of The PA3
//Author: Deniz Caner Akdeniz
//ID: 14021504096
//Section: 5
//Assignment: 3
//Description: most of the methods for inputs work here.
//	when it's neccesary we invoke bts method from it's class.
//-----------------------------------------------------
//Author: Berke Cem Öktem
//ID: 11179893010
//Section: 3
//-----------------------------------------------------
public class BinarySearchTree {

	//node class that defines BST node
	private static class Node { 
		int key;
		String name;
		String available;
		int star;
		Node left, right; 

		public Node(int key,String name,String available,int star){ 
			this.key = key; 
			this.name=name;
			this.available=available;
			this.star=star;
			this.left = this.right = null; 
		} 
	} 
	// BST root node 
	protected static Node root; 

	// Constructor for BST =>initial empty tree
	protected BinarySearchTree(){ 
		root = null; 
	} 
	//delete a node from BST
	public static void deleteKey(int key) { 
		root = delete_Recursive(root, key); 
	} 

	//recursive delete function
	protected static Node delete_Recursive(Node root, int key)  { 
		//tree is empty
		if (root == null)  return root; 

		//traverse the tree
		if (key < root.key)     //traverse left subtree 
			root.left = delete_Recursive(root.left, key); 
		else if (key > root.key)  //traverse right subtree
			root.right = delete_Recursive(root.right, key); 
		else  { 
			// node contains only one child
			if (root.left == null) 
				return root.right; 
			else if (root.right == null) 
				return root.left; 

			// node has two children; 
			//get inorder successor (min value in the right subtree) 
			root.key = minValue(root.right); 

			// Delete the inorder successor 
			root.right = delete_Recursive(root.right, root.key); 
		} 
		return root; 
	} 

	protected static int minValue(Node root)  { 
		//initially minval = root
		int minval = root.key; 
		//find minval
		while (root.left != null)  { 
			minval = root.left.key; 
			root = root.left; 
		} 
		return minval; 
	} 

	// insert a node in BST 
	protected static void insert(int key, String name, String available,int star)  { 
		root = insert_Recursive(root, key, name, available, star); 
	} 

	
	//recursive insert function
	protected static Node insert_Recursive(Node root, int key, String name, String available, int star) { 
		//tree is empty
		if (root == null) { 
			root = new Node(key, name, available, star); 
			return root; 
		} 
		//traverse the tree
		if (key < root.key)     //insert in the left subtree
			root.left = insert_Recursive(root.left, key, name, available, star); 
		else if (key > root.key)    //insert in the right subtree
			root.right = insert_Recursive(root.right, key, name, available, star); 
		// return pointer
		return root; 
	} 

	// method for inorder traversal of BST 
	protected static void inorder() { 
		inorder_Recursive(root); 
	} 

	// recursively traverse the BST  
	protected static void inorder_Recursive(Node root) { 
		Node x= root;
		if (x != null) { 
			inorder_Recursive(x.left); 
			System.out.println("--CAPTAIN:");
			System.out.println("\r\n"
	    			+ "		       ID: "+x.key+"\r\n"
	    			+ "		       Name: "+x.name+"\r\n"
	    			+ "		       Available:  "+x.available+"\r\n"
	    			+ "		       Rating Star: "+x.star+"");
			inorder_Recursive(x.right); 
		} 
	} 
	protected static String[] search(int key)  { 
		Node x = get(key);
		if (x!= null) {
			String[]arr1= {String.valueOf(x.key),x.name,x.available,String.valueOf(x.star)}; 
			return arr1;}
		else {
			String[]arr1= {"0","0","0","0"};
			return arr1;}
	} 
	protected static Node get(Integer key) {
		Node x=root;
		while(x !=null) {
			int cmp =key.compareTo(x.key);
			if (cmp<0) x= x.left;
			else if (cmp>0) x= x.right;
			else if (cmp==0) return x;
		}
		return null;
	}
	
	protected static String[] changer(int key,int r) {
		Node x = get(key);
		String[] arr1=search(key);

		System.out.println(arr1[0]+" "+arr1[1]+" "+arr1[2]+" "+arr1[3]);
		if(root!=null && root.available.equals("True")&& r==0) {
			deleteKey(key);
			insert(Integer.valueOf(arr1[0]), arr1[1], "False", Integer.valueOf(arr1[3]));
			return new String[]{arr1[0], arr1[1], "False", arr1[3]};	}
		else if (root!=null && root.available.equals("False")&& r==1)
			{ insert(Integer.valueOf(arr1[0]), arr1[1], "True", Integer.valueOf(arr1[3]));
			return new String[]{arr1[0], arr1[1], "True", arr1[3]};	}
		else 
			{ return new String[]{"0","0","0","0"};}
	}
	protected static String[] IncStar(int key,String r) {
		Node x= get(key);
		String[] arr1=search(key);
		int star=Integer.valueOf(arr1[3]);
		System.out.println(arr1[0]+" "+arr1[1]+" "+arr1[2]+" ");
		if(x!=null && r.equals("1")) {
			deleteKey(key);
			star+= 1;
			insert(Integer.valueOf(arr1[0]), arr1[1], arr1[2], star);}
		return new String[]{arr1[0], arr1[1], "True", String.valueOf(star)}; 
	}




}

