import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int answer;
	static int[] arr, select;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		isvisited = new boolean[arr.length];
		select = new int[arr.length];
		
		answer = 0;
		permutation(0);
		
		//출력
		System.out.println(answer);
	}
	
	
	//순열
	public static void permutation(int idx) {
		if(arr.length<=idx) {
			int sum = 0;
			for(int i=0; i<select.length-1; i++) {
				sum+=Math.abs(arr[select[i]] - arr[select[i+1]]);
			}
			
			answer = Math.max(sum, answer);
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(isvisited[i]) continue;
			
			isvisited[i] = true;
			select[i] = idx;
			permutation(idx+1);
			
			isvisited[i] = false;
		}
	}
}
