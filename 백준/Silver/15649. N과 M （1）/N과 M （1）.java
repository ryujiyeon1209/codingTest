import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int[] arr, sel;
	static boolean[] isselected;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];	//n부터 n까지 수를 담을 배열
		sel = new int[m];	//m개를 고른 수를 담을 배열
	
		isselected = new boolean[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		sb = new StringBuilder();
		permutation(0);
		
		//출력
		System.out.println(sb.toString());
	}
	
	//순열
	public static void permutation(int idx) {
		
		if(m<=idx) {
			for(int i=0; i<sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(isselected[i]) continue;
			
			isselected[i] = true;
			sel[idx] = arr[i];
			
			permutation(idx+1);
			
			isselected[i] = false;
		}
	}
}
