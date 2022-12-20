package question2;

import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithmTester {
	
	public static void main(String[] args) {
//	int seed =takeSeed();
	int seed= 11;
	testCase(seed,250);
	testCase(seed,1000);
	testCase(seed,4000);
	testCase(seed,16000);
	testCase(seed,64000);
	}
	private static void testCase(int seed,int size) {
		System.out.println("Input size: " + size);
		System.out.println("");
		Integer[] arr=	rndArray(seed,size);
		Integer[] arr1=	arr;
		Integer[] arr2=arr;

		System.out.println("Selected Sort: Selection");
 		Long t1 = System.currentTimeMillis();
		timer("Selection",arr1,arr2,t1);	
		arr1=	arr;
		arr2=arr;
		t1 = System.currentTimeMillis();
		System.out.println("Selected Sort: Insertion");
		timer("Insertion",arr1,arr2,t1);
		arr1=	arr;
		arr2=arr;
		t1 = System.currentTimeMillis();
		System.out.println("Selected Sort: Merge");
		timer("Merge",arr1,arr2,t1);	
		arr1=	arr;
		arr2=arr;
		t1 = System.currentTimeMillis();
		System.out.println("Selected Sort: Quick");
		timer("Quick",arr1,arr2,t1);
	}
	private static void timer(String chs,Integer[] arr,Integer[]arr1,Long t1) {
		 	System.out.println("Random");	
		 	Method.randomPairwiseDifference(arr);
		 	Long t2 = System.currentTimeMillis();
//		 	System.out.println("Time: " + (t2-t1));

		 	System.out.println("Ascending");	
		 	Method.choosenSortMethod(chs,arr);
		 	Method.orderedPairwiseDifference(arr);
		 	Long t3 = System.currentTimeMillis();
//		 		System.out.println("Time: " + (t3-t2));

		 	System.out.println("Descending");
		 	Method.choosenSortMethod(chs,arr1);
		 	reversedArray(arr1);
		 	Method.orderedPairwiseDifference(arr);
		 	Long t4 = System.currentTimeMillis();
//		 	System.out.println("Time: " + (t4-t3));
	 }
	 private static int takeSeed() {
			Scanner scn = new Scanner(System.in);
		    System.out.println("Enter a seed to create random generated values :");
		    int seed= scn.nextInt();
		    return seed;
		    }
	 private static Integer[] rndArray(int seed,int size) {
		// TODO Auto-generated method stub
	     Random random = new Random(seed);
		 Integer[] arr=new Integer[size];
		 for(int i = 0; i < size; i++){
		        arr[i] = random.nextInt();
		    }	 
		return arr;
	}
	 private static Integer[] reversedArray(Integer[] arr) {
		 Integer[] rArr= new Integer[arr.length];
		 int j=arr.length-1;
		 for(int i = 0; i < rArr.length-1; i++) {
			 rArr[i]=arr[j];
			 --j;
		 }
		 return rArr;
	 }
		 
	 }
	

