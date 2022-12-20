package question1;

public class Merge
{
	private static void mergeInc(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	} 
	private static void mergeDec(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (bigg(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	} 
	private static void sortInc(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sortInc(a, aux, lo, mid);
		sortInc(a, aux, mid+1, hi);
		mergeInc(a, aux, lo, mid, hi);
	}
	public static void sortInc(Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length];
		sortInc(a, aux, 0, a.length - 1);
	}
	
	private static void sortDec(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sortDec(a, aux, lo, mid);
		sortDec(a, aux, mid+1, hi);
		mergeDec(a, aux, lo, mid, hi);
	}
	public static void sortDec(Comparable[] a)
	{	
		System.out.println("The array of integer values has been sorted in descending order by using the merge sort algorithm is:");
		Comparable[] aux = new Comparable[a.length];
		sortDec(a, aux, 0, a.length - 1);
	}
	private static boolean less(Comparable v, Comparable w)
	{ 	return v.compareTo(w) < 0; }
	private static boolean bigg(Comparable v, Comparable w)
	{ 	return v.compareTo(w) > 0; }
	 
	 

}

	