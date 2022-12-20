package Question2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
//-----------------------------------------------------
//Title: Main Class of The PA3
//Author: Deniz Caner Akdeniz
//ID: 14021504096
//Section: 5
//Assignment: 3
//Description: most of the methods for inputs work here.
// 	when it's neccesary we invoke bts method from it's class.
//-----------------------------------------------------
//Author: Berke Cem Öktem
//ID: 11179893010
//Section: 3
//-----------------------------------------------------
public class Main {
	public static void main(String[] args)  { 
		System.out.println("--------------- WELCOME TO CDRC SYSTEM ---------------");
		BinarySearchTree bst = new BinarySearchTree(); 
			readingFile();
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
//  input_Q2.txt
				String[]arr  = line.split("\\s+");
				if(arr.length==0) break;
//				System.out.println(Arrays.toString(arr));
				command(arr);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thank you for using CDRC, Good Bye!");
	}
	protected static void command(String[] array) {
  		 	String s = array[0];
			switch(s) {
			case"Add_Captain":
		        addCaptain(array); printspace();
		        break;
			case"Is_Available":
	        	isAvailable(array); printspace();
		        break;

			case"Display_captain":
				displayCaptain(array); printspace();
		        break;

			case"Finish":
				finish(array); printspace();
		        break;

			case"Delete_captain":
				deleteCaptain(array); printspace();
		        break;

			case"Display_all_captains":
				displayAllCaptains(array); printspace();
		        break;

			default:
				break;
			}

	}		
	private static void printspace() {
		System.out.println();
		System.out.println("----------------------------------------------------------------");
	}
	private static void addCaptain(String[] array) {
		int a = Integer.parseInt(array[1]);
    	BinarySearchTree.insert(a, array[2],"True",0); 
    	System.out.println("Add Captain: Add a new captain record in the System");
    	System.out.println();
    	System.out.println("\r\n"
    			+ "		       ID: "+array[1]+"\r\n"
    			+ "		       Name: "+array[2]+"\r\n"
    			+ "		       Available: True\r\n"
    			+ "		       Rating star: "+0+"");
	}
	
	private static void isAvailable(String[] array) {
		int a = Integer.parseInt(array[1]);
    	String[] arr1 = BinarySearchTree.search(a);
    	int a1 = Integer.parseInt(arr1[0]);
    	if(Integer.parseInt(arr1[0])!=0&&arr1[2].equals("True")) {
	    	System.out.println("IsAvailable: Reserve a new Ride with captain "+a1);
	    	BinarySearchTree.changer(a1,0);
    	}
    	else if(Integer.parseInt(arr1[0])!=0&&arr1[2].equals("False")) {
	    	System.out.println("IsAvailable: The captain "+arr1[1]+" is not available. He is on another ride!");
    	}
    	else if(Integer.parseInt(arr1[0])==0) 
    		System.out.println("IsAvailable: Couldn't find any captain with ID number "+a1);
	}
	
	private static void finish(String[] array) {
		int a = Integer.parseInt(array[1]);
		String b = array[2];
    	String[] arr1 = BinarySearchTree.search(a);


    	if(Integer.parseInt(arr1[0])!=0&&arr1[2].equals("False")) {
			System.out.println("Finish: Finish ride with captain "+arr1[0]);
	    	BinarySearchTree.changer(a,0);
	    	String[] arr2=BinarySearchTree.IncStar(a,b);
	    	printCaptain(arr2);}
    	else if(Integer.parseInt(arr1[0])!=0&&arr1[2].equals("True")) {
    		System.out.println("Finish: The captain "+arr1[0]+" is not in a ride");}
    	else if(Integer.parseInt(arr1[0])==0) 
    		System.out.println("Finish: Couldn't find any captain with ID number "+a);
		}
	
	private static void deleteCaptain(String[] array) {
		int a = Integer.parseInt(array[1]);
    	String[] arr1 = BinarySearchTree.search(a);
    	if(Integer.parseInt(arr1[0])==0) 
    		System.out.println("Delete Captain: Couldn't find any captain with ID number "+a);
    	else {
			BinarySearchTree.deleteKey(a);
			System.out.println("Delete Captain:The captain Can left CCR");
    	}

	}
	
	private static void displayAllCaptains(String[] array) {

		System.out.println("----------ALL CAPTAINS----------\r\n");
		BinarySearchTree.inorder();
	}
	private static void displayCaptain(String[] array) {
		int a = Integer.parseInt(array[1]);
		System.out.print("DisplayCaptain: ");
		String[] arr1 = BinarySearchTree.search(a);
		if(arr1[1].equals("0"))
			{
			System.out.println("Couldn't find any captain with ID number "+a);
			System.out.println();}
		else {
			printCaptain(arr1);
		}	
	}
	private static void printCaptain(String[]array) {
		System.out.println("\r\n"
    			+ "		       ID: "+array[0]+"\r\n"
    			+ "		       Name: "+array[1]+"\r\n"
    			+ "		       Available: "+array[2]+"\r\n"
    			+ "		       Rating star: "+array[3]+"");
		printspace();}
		

}

