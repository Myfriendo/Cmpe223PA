package pa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import pa.Pa1a.Node;

public class Pa1b {

	public static Scanner scanner1 = new Scanner(System.in);
	public static void main(String[] args)
	{	
		Pa1b task = new Pa1b();
		int[][] matrix=task.matrixReader();
		System.out.println();

		int rows = matrix.length;
		int cols = matrix[0].length;
		int elements = rows*cols;
		System.out.println("Input filename:");
		String filename = scanner1.nextLine();
		String[] listF=task.listReader(filename);
		System.out.println("Input filename:");
		filename = scanner1.nextLine();
		String[] listS= task.listReader(filename);
		task.putIntoNode(listF, listS);
		task.convertMatrix(matrix);
		if(elements==(listF.length+listS.length)) {task.isListFHugListS(true,listS,rows,cols,matrix);}
		else {System.out.println("FALSE");}
//		task.linkedlist();
	}
	public void linkedlist() 
	{
		Node current =head;
		if(head == null) {    
            System.out.println("List is empty");    
            return;    
        } 
		while(current != null) {System.out.print(current.data+" "); current=current.next;}
	}

	public int[][] matrixReader()  {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input filename:");
		String filename = scanner.nextLine();
		
		int rows =0;
		int columns =0;
// declare file type file to don't use every time first scanner reads rows and columns so that ı can create 2d array.
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				++rows;
				columns=0;
				String[] arrS = line.split(" ");
				for(String a : arrS) {++columns;}
				
			}
			reader.close();
		} catch (IOException e) {e.printStackTrace();}
		int[][] matrix = new int[rows][columns];
//		second one used to take matrix elements from same file.
		try {
			int i = 0;
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String [] arrS = line.split(" ");
				int sa =arrS.length;
				int[] arrI = new int[sa];
				for(int a=0; a<sa;a++) {arrI[a]= Integer.parseInt(arrS[a]);}

				int j =0;
				for(int c : arrI) {matrix[i][j]=c; ++j;}
				++i;	
			}
			reader.close();
		} catch (IOException | NumberFormatException e) {e.printStackTrace();}
//	third buffer reader for list1
		
		return matrix;
	}
	
	public String[] listReader(String filename) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String [] arrS = line.split("-");
				return arrS;
			}
			reader.close();
		} catch (IOException | NumberFormatException e) {e.printStackTrace();}
		return null;
		
		
	}
// set empty linked list
	public Node head=null;
	public Node tail=null;
// node of the linked list 	
	
	class Node
	{
		String data;
		Node next; 
		public Node(String data) 
		{ this.data=data; this.next=null; }	
	}
//	used this for adding new member in linked list
	public void addNode(String data) 
	{
		Node newNode = new Node(data);
//		checking if added node first node by looking the head is empty(null)
		if(head==null) 
		{ head=newNode; tail=newNode; }
//		if it's not empty change old tail's pointer value from null to newNode's value and create new value 
		else 
		{ tail.next=newNode; tail=newNode; }
	}
//	rows x cols y
	public void putIntoNode(String[] listf,String[] lists) 
	{for(String c:listf){addNode(c+" 1");} for(String d:lists){addNode(d+" 0");}}
	public void convertMatrix(int[][] matrix) 
	{
		
		for(int i =0; i<matrix.length; i++) {
			for(int j =0; j< matrix[0].length; j++) {
				Node current =head;
				while(current != null) {
					if(i==Integer.parseInt((current.data).substring(0,1))&&j==Integer.parseInt((current.data).substring(2,3))) {
					matrix[i][j]=Integer.parseInt((current.data).substring(4)); }
					current=current.next;
			}}}
	}
	public void isListFHugListS(boolean control,String[] listS,int rows,int cols,int[][] matrix) 
	{	
		for (int i = 0; i<rows; i++) {
		    for (int j = 0; j<cols; j++) {
		        System.out.print(matrix[i][j]);
		    }
		}
		while(control) 
		{
			for(String c:listS) {
				int x= Integer.parseInt(c.substring(0,1));
				int y= Integer.parseInt(c.substring(2,3));


				if((x!=0&&x<rows-1)&&(y!=0&&y<cols-1)) {
					if(matrix[x-1][y]!=1&& matrix[x-1][y]!=0) {control=false;}
					if(matrix[x+1][y]!=1&& matrix[x+1][y]!=0) {control=false;}
					if(matrix[x][y-1]!=1&& matrix[x][y-1]!=0) {control=false;}
					if(matrix[x][y+1]!=1&& matrix[x][y+1]!=0) {control=false;}
				}
				else {control=false;}
		}break;}

		if(control) {System.out.println("TRUE");}
		else {System.out.println("FALSE");}
	}


}
