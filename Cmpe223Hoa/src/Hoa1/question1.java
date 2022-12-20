package Hoa1;

public class question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myIntArray = {1, 5, 3};
		int a=0;
		for(int i :myIntArray) {
			if(i>a) { a=i;}
		}
		System.out.println(a);
	}

}
