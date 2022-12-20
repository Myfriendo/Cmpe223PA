package Hoa1;

public class question2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myIntArray = {1, 5, 3};
		int a=0;
		int b=0;

		for(int i :myIntArray) {
			if(i>a) { a=i;}	
		}
		for(int i :myIntArray) {
			if(i>b&&i!=a ) { b=i;}	
		}
		System.out.println(b);
	}
}
