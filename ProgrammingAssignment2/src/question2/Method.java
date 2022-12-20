package question2;

import java.util.Scanner;

public class Method {
	public static void main(String[] args) {
	
	Integer[] arr1= {113, 23, 1, 109, 4, 102, 7, 105, 100, 107};
	
	int a = choosenSortMethod(takeInput(),arr1);
	if(a!=0)orderedPairwiseDifference(arr1);
		
	}
	protected static String takeInput() {
		Scanner scn = new Scanner(System.in);
	    System.out.println("Enter the sort you want to use:");
	    String choosen= scn.next();
	    return choosen;
	    }
	protected static int choosenSortMethod(String chs,Integer[]arr1) {
		String a=chs.toLowerCase();
		switch(a) {
		case "insertion":Insertion.sort(arr1); return 1;		
		case "merge":Merge.sort(arr1); return 1;
		case "quick":Quick.sort(arr1); return 1;
		case "selection":Selection.sort(arr1); return 1;

		default: System.out.println("Enter a valid sorting algorithm"); return 0;
		
		}
		
	}


	protected static void orderedPairwiseDifference(Integer[] arr1) {

		int minDiff=2147483647;
		int current=0;
		for(int i=0; i < (arr1.length-1); i++) {
			int a =Math.abs(arr1[i] - arr1[i+1]);
			int b =(arr1[i] + arr1[i+1]);
			if(a < minDiff) {
				minDiff=a;
				current=i;
			}}
//		System.out.println(Math.abs(minDiff)+" ["+arr1[current]+" "+arr1[current+1]+"]");
	
	}
	protected static void randomPairwiseDifference(Integer[] arr1) {
		int minDiff=2147483647;
		int currenti=0;
		int currentj=0;

		for(int i=0; i < (arr1.length-1); i++) {
			for(int j=0; j < (arr1.length-1); j++) {
				if(i!=j) {
					int a =Math.abs(arr1[i] - arr1[j]);
					if(a < minDiff) {
						minDiff=a;
						currenti=i;
						currentj=j;
					}
				}
			}
		}
//		System.out.println(Math.abs(minDiff)+" ["+arr1[currenti]+" "+arr1[currentj]+"]");
	
	}
}
