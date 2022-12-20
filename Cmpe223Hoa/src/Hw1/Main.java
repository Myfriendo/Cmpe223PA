package Hw1;
import java.io.*;
import java.util.Scanner;

public class Main {
	
	public void main(String[] args) throws FileNotFoundException 
	{
		Main task = new Main();
		int[][] matrix=matrixReader();
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i=0; i<rows; i++) {
			for(int j=0; i<cols; j++) {
				System.out.println(matrix[i][j]);
				System.out.println("a");

			}
		}
		task.spiralList(0,0,rows,cols,matrix);
		task.linkedlist();
	}
	public int[][] matrixReader() throws FileNotFoundException {
		int rows =0;
		int columns =0;
// declare file type file to don't use every time first scanner reads rows and columns so that ı can create 2d array.
		File file = new File("\\txt-files\\Q1A\\matrix.txt");
		Scanner input = new Scanner(file);
			while (input.hasNextLine()) 
			{
				++rows;
				Scanner col= new Scanner(input.nextLine());
				while (col.hasNextInt()) {++columns;}
			}
		int[][] matrix = new int[rows][columns];
		input.close();
//		second one used to take matrix elements from same file.
		input=new Scanner(file);
		for (int i=0; i<rows; i++) {for (int j=0; j<columns; j++) {if(input.hasNextLine()) {matrix[i][j]=input.nextInt(); } } }
		input.close();

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
	public void spiralList(int x1, int y1, int x2, int y2, int[][] elm) 
	{
		int matrixelements= x2*y2;
		int nodec=0;
		while(true) 
		{
			for(int i=x1; i<y2 ; i++) // from up right to down
			{
				if(nodec<=matrixelements) {return;}
				if(elm[x1][i]!=-1) {return;}
				++nodec;
				addNode(elm[x1][i]);
			}
			++y1;
			for(int i=0; i<x2; i++) //	from down righ
			{
				if(nodec<=matrixelements) {return;}
				if(elm[i][y2]!=-1) {return;}
				++nodec;
				addNode(elm[i][y2]);
			}
			--x2;
			for(int i=x2; i>=x1 ; i--) //	
			{
				if(nodec<=matrixelements) {return;}
				if(elm[x2][i]!=-1) {return;}
				++nodec;
				addNode(elm[x2][i]);
			}
			--y2;
			for(int i=y2; i<y1 ; i--) //	
			{
				if(nodec<=matrixelements) {return;}
				if(elm[i][y1]!=-1) {return;}
				++nodec;
				addNode(elm[i][y1]);
			}
			++x1;
		}
	}
	public void linkedlist() 
	{
		Node current =head;
		while(current != null) {System.out.print(current.data+""); current=current.next;}
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}

}
