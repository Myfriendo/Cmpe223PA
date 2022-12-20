package question1;

public class Insertion
{
//	 I just add one more sorting which is decreasing order.
//	 I also add the opposite of the less which is look if it's bigger than previous one. Logic is is same to less.
	public static void decsort(Comparable[] a)
	{
	System.out.println("The array of integers that has been sorted in decreasing order by using the insertion sort algorithm:");

	 for (int i = 0; i < a.length; i++)
		 for (int j = i; j > 0; j--)
			 if (bigg(a[j], a[j-1]))
				 exch(a, j, j-1);
			 else break;
	}
	public static void incsort(Comparable[] a)
	{	
	System.out.println("The array has been sorted in increasing order by using the insertion sort algorithm:");

	 for (int i = 0; i < a.length; i++)
		 for (int j = i; j > 0; j--)
			 if (less(a[j], a[j-1]))
				 exch(a, j, j-1);
			 else break;
	}
	private static boolean bigg(Comparable v, Comparable w)
	{ 	return v.compareTo(w) > 0; }
	
	private static boolean less(Comparable v, Comparable w)
	{ 	return v.compareTo(w) < 0; }
 
	private static void exch(Comparable[] a, int i, int j)
	{ 	Comparable swap = a[i]; a[i] = a[j]; a[j] = swap; }
}