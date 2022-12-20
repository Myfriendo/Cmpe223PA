package Question1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import Question1.BinarySearchTree;

public class Main {
	public static void main(String[] args)  { 
//			tester();
			readingFile();
	     } 
	public static void tester() {
    	BinarySearchTree bst = new BinarySearchTree(); 

    	BinarySearchTree.insert(56,"skirt",2); 
        System.out.println("Test case 1 done");
    	BinarySearchTree.insert(95,"hat",6); 
        System.out.println("Test case 2 done");
        BinarySearchTree.search (12);
        System.out.println("Test case 3 done");
        BinarySearchTree.search (12);
        System.out.println("Test case 4 done");
		readingFile();
        System.out.println("Test case 5 done");

	}
	
	protected static void readingFile() {
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.nextLine();
		scanner.close();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while((line = reader.readLine())!=null)
			{
//  input_Q1.txt
				String[]arr  = line.split("\\s+");
				if(arr.length==0) break;
//				System.out.println(Arrays.toString(arr));
				instructionFollower(arr);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    	System.out.println("Thank you for using ITS, Good Bye!");
	}
	protected static void instructionFollower(String[] array) {
		
  		 	String s = array[0];
  		 	switch(s) {
  		 	case "Add_product":
  		 		Add_product(array);
  		 	case "Is_Available":
  		 		Is_Available(array);
  		 	default: 
  		 		break;
  		 	}
		
	}
	protected static void Add_product(String[] array) {
		int a = Integer.parseInt(array[1]);
        int b = Integer.parseInt(array[3]);
    	BinarySearchTree.insert(a, array[2], b); 
    	System.out.println("Create Product:");
    	System.out.println("\r\n"
    			+ "		       ID: "+array[1]+"\r\n"
    			+ "		       Name: "+array[2]+"\r\n"
    			+ "		       Piece: "+array[3]+"");
	}
	
	protected static void Is_Available(String[] array) {
		int a = Integer.parseInt(array[1]);
    	int[] arr1 = BinarySearchTree.search(a);
    	if(arr1[0]==1) {
	    	System.out.println("There are "+arr1[1]+" products");
    	}
    	else System.out.println("The product is out of stock!!!");
	}
			
	
	
}

