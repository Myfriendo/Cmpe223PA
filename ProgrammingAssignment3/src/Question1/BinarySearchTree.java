package Question1;

public class BinarySearchTree {

	//node class that defines BST node
    private static class Node { 
        int key;
        String name;
        int piece;
        Node left, right; 
   
        public Node(int data,String name,int piece){ 
            key = data; 
            this.name=name;
            this.piece=piece;
            left = right = null; 
        } 
    } 
    // BST root node 
    protected static Node root; 
  
   // Constructor for BST =>initial empty tree
    BinarySearchTree(){ 
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
    protected static void insert(int key, String name, int piece)  { 
        root = insert_Recursive(root, key, name, piece); 
    } 
   
    //recursive insert function
    protected static Node insert_Recursive(Node root, int key, String name, int piece) { 
          //tree is empty
        if (root == null) { 
            root = new Node(key,name, piece); 
            return root; 
        } 
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key, name, piece); 
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key, name, piece); 
          // return pointer
        return root; 
    } 
 
// method for inorder traversal of BST 
    protected static void inorder() { 
        inorder_Recursive(root); 
    } 
   
    // recursively traverse the BST  
    protected static void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " "); 
            inorder_Recursive(root.right); 
        } 
    } 
     
    protected static int[] search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null) {
        	int[]arr1= {1,root.piece};
            return arr1;}
        else {
        	int[]arr1= {0,0};
            return arr1;}
        }
   
   
    //recursive insert function
    protected static Node search_Recursive(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key) 
            return root; 
        // val is greater than root's key 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 
}

