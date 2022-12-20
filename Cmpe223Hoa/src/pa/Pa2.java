package pa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Pa2 {
	
	public static Scanner scanner = new Scanner(System.in);
	public static Stack<Integer> stack = new Stack<Integer>();
	public static Queue<Integer> queue = new ArrayDeque<Integer>();
	public static Queue<Integer> queue1 = new ArrayDeque<Integer>();



	public static void main(String[] args) {
		Pa2 task = new Pa2();
		
		System.out.println("Input filename:");
		String filename = scanner.nextLine();
		List<Integer> list=task.listReader(filename);
//		for (int i:list) {
//			System.out.println(i);
//		}
		task.riseStack(0,list);
	
	}
	
	public List<Integer> listReader(String filename) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				List<Integer> arrS = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
				return arrS;
			}
			reader.close();
		} catch (IOException | NumberFormatException e) {e.printStackTrace();}
		return null;
		
		
	}
	public void riseStack(int count,List<Integer> list) {
		for(int e:list) {
			count=0;
			stack.push(e);
			for(int i=0;i<=stack.size();i++) {
				int de = stack.pop();				
				queue.add(de);
				if(e<=de) {count++;}
			}
			queue1.add(count);
			for(int q:queue) {
				stack.push(queue.poll());
			}
		}
		for(int q:queue1) {
			int count1 = queue1.poll();
			System.out.print(count1+" ");
		}
	}
}
