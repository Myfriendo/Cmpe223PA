package question1;
import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

public class ReadingFile {

	public static void main (String[] args)
	{
		//see no path
		int numbers[] = readFilesInt("integers.txt");
		int n = numbers.length;
		// you need to use Integer[] not int[] in order to use Comparable[]
		Integer[] arr = new Integer[n]; 
		//filling the array with integers coming from the txt file
		for(int i=0; i < n; i++)
		{
			arr[i] = numbers[i];
		}
		printArray(arr);

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
