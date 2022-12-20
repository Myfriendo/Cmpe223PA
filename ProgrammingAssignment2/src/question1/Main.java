package question1;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		task1
		Integer[] arr1=callReadInt();
		printArray(arr1);
		Insertion.incsort(arr1);
		printArray(arr1);
		System.out.println("Step 1 has been completed.");
//		task2
		Insertion.decsort(arr1);
		printArray(arr1);
		System.out.println("Step 2 has been completed.");
//		task3
		Double[] arr2=callReadDouble();
		printArray(arr2);
		Insertion.incsort(arr2);
		printArray(arr2);
		System.out.println("Step 3 has been completed.");
//		task4
		Integer[] arr3=callReadInt();
		printArray(arr3);
		Merge.sortDec(arr3);
		printArray(arr3);
		System.out.println("Step 4 has been completed.");

// 		task5
		Route[] routes = new Route[10];
        routes[0] = new Route("Ankara", "Antalya");
        routes[1] = new Route("Ankara", "Istanbul");
        routes[2] = new Route("Ankara", "Izmir");
        routes[3] = new Route("Antalya", "Ankara");
        routes[4] = new Route("Antalya", "Izmir");
        routes[5] = new Route("Istanbul", "Ankara");
        routes[6] = new Route("Istanbul", "Antalya");
        routes[7] = new Route("Istanbul", "Izmir");
        routes[8] = new Route("Izmir", "Ankara");
        routes[9] = new Route("Izmir", "Antalya");
//      task6
        Quick.sort(routes, 1);
        
        for (int i = 0; i < routes.length; i++) 
        	System.out.println(routes[i].getSource() + " " + routes[i].getDestination());
        
		System.out.println("Step 6 has been completed.");
//		task 7
//        Quick.sort(routes, 0);
//        for (int i = 0; i < routes.length; i++) 
//       	 System.out.println(routes[i].getSource() + " " + routes[i].getDestination());
//		System.out.println("Step 7 has been completed.");
//		as you dont put those on the vpl  I turn those codes to comment.
		}
//	it's just to copy of the reading file main.
	public static Integer[] callReadInt(){
		System.out.println("Integers are reading from the integers.txt file, the array is:");
		int numbers[] = readFilesInt("integers.txt");
		int n = numbers.length;
		// you need to use Integer[] not int[] in order to use Comparable[]
		Integer[] arr = new Integer[n]; 
		//filling the array with integers coming from the txt file
		for(int i=0; i < n; i++)
		{
			arr[i] = numbers[i];
		}
		return arr;
	}
	public static Double[] callReadDouble(){
		System.out.println("Doubles are reading from the doubles.txt file, the array is:");
		double numbers[] = readFilesDouble("doubles.txt");
		int db = numbers.length;
		// you need to use Integer[] not int[] in order to use Comparable[]
		Double[] arr = new Double[db]; 
		//filling the array with integers coming from the txt file
		for(int i=0; i < db; i++)
		{
			arr[i] = numbers[i];
		}
		return arr;
	}
	
	
	protected static int[] readFilesInt(String file) {
		try {
			File f = new File(file);
			Scanner s = new Scanner(f);
			int n = 0;

			while(s.hasNextInt())
			{
				n++;
				s.nextInt();
			}
			int S[] = new int[n];

			Scanner s1 = new Scanner(f);

			for(int i =0; i < S.length; i++)
				S[i] = s1.nextInt();

			return S;

		}
		catch(Exception e) {
			return null;
		}
	}
	protected static double[] readFilesDouble(String file) {
		try {
			File f = new File(file);
			Scanner s = new Scanner(f);
			int db = 0;

			while(s.hasNextDouble())
			{
				db++;
				s.nextDouble();
			}
			double S[] = new double[db];

			Scanner s1 = new Scanner(f);

			for(int i =0; i < S.length; i++)
				S[i] = s1.nextDouble();

			return S;

		}
		catch(Exception e) {
			return null;
		}
	}
	public static void printArray(Comparable[] arr)

	{
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
			System.out.println();
	}
}
