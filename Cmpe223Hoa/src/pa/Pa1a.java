package pa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Pa1a {
	public static void main(String[] args)
	{	
		Pa1a task = new Pa1a();
		int[][] matrix=task.matrixReader();

		int rows = matrix.length;
		int cols = matrix[0].length;
		int elements = rows*cols;
		task.spiralList(0,0,rows-1,cols-1,matrix,elements);
		task.linkedlist();
	}

	public int[][] matrixReader()  {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input filename:");
		String filename = scanner.nextLine();
		scanner.close();
		
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
		return matrix;
	}
// set empty linked list
	public Node head=null;
	public Node tail=null;
// node of the linked list 	
	
	class Node
	{
		int data;
		Node next; 
		public Node(int data) 
		{ this.data=data; this.next=null; }	
	}
//	used this for adding new member in linked list
	public void addNode(int data) 
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
	public void spiralList(int x1, int y1, int x2, int y2, int[][] elm, int elem) 
	{
		int nodec=0;
		while(true) 
		{
			for(int i=x1; i<=x2 ; i++) // from up right to down
			{
				if(nodec>=elem) {return;}
				if(elm[i][y1]==-1) {return;}
				++nodec;
				addNode(elm[i][y1]);
				
			}
			++y1;
			for(int i=y1; i<=y2; i++) //	from down righ
			{
				if(nodec>=elem) {return;}
				if(elm[x2][i]==-1) {return;}
				++nodec;
				addNode(elm[x2][i]);
			}
			--x2;
			for(int i=x2; i>=x1 ; i--) //	
			{
				if(nodec>=elem) {return;}
				if(elm[i][y2]==-1) {return;}
				++nodec;
				addNode(elm[i][y2]);
			}
			--y2;
			for(int i=y2; i>=y1 ; i--) //	
			{
				if(nodec>=elem) {return;}
				if(elm[x1][i]==-1) {return;}
				++nodec;
				addNode(elm[x1][i]);
			}
			++x1;

		}
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

}
