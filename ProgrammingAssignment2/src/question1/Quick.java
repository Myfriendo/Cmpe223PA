package question1;


public class Quick {

	private static int partitionInc(Route[] a, int lo, int hi)
	{
		int i = lo, j = hi+1;
		while (true)
		{
			while (less(a[++i], a[lo]))
				if (i == hi) break;
			while (less(a[lo], a[--j]))
				if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	private static int partitionDec(Route[] a, int lo, int hi)
	{
		int i = lo, j = hi+1;
		while (true)
		{
			while (bigg(a[++i], a[lo]))
				if (i == hi) break;
			while (bigg(a[lo], a[--j]))
				if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	public static void sort(Route[] a,int desOrInc)
	{
		StdRandom.shuffle(a);
		if(desOrInc==1) sortInc(a, 0, a.length - 1);
		else sortDes(a, 0, a.length - 1);
	}
	private static void sortInc(Route[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int j = partitionInc(a, lo, hi);
		sortInc(a, lo, j-1);
		sortInc(a, j+1, hi);
	}
	private static void sortDes(Route[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int j = partitionDec(a, lo, hi);
		sortDes(a, lo, j-1);
		sortDes(a, j+1, hi);
	}

	private static boolean less(Route v, Route w)
	 { 	return v.compareTo(w) < 0; }
	private static boolean bigg(Route v, Route w)
	 { 	return v.compareTo(w) > 0; }
	
	private static void exch(Route[] a, int i, int j)
	 { Route swap = a[i]; a[i] = a[j]; a[j] = swap; }
}
