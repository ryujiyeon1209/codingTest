import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int[] arr;
	static int[] choose;
	static boolean[] isvisited;
	public static StringBuilder sb = new StringBuilder();
	
	//자연수 중에 m개를 고르는 수열 > 같은 수를 여러번 골라도 된다 > 수열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//기준 숫자
		m = sc.nextInt();	//숫자 중 내가 고르는 개수
		
		arr = new int[n];		//내가 고를 숫자들이 있는 배열
		for(int i=0; i<arr.length; i++) arr[i] = i+1;
		
		choose = new int[m];	//내가 고른 숫자들이 있는 배열
		isvisited = new boolean[n];
		
		Solution(0);
		
		System.out.println(sb.toString());
		
	}
	
	public static void Solution(int idx) {
		
		//다 골랐으면, 재귀 멈추기
		if(idx==m) {
			
			//시간초과나서 stringBuilder써야한다.
			for(int i=0; i<choose.length; i++) {
				sb.append(choose[i] + " ");
			}
			
			sb.append("\n");
			return;
		}

		//숫자 고르기
		for(int i=0; i<n; i++) {
			//중복 검사가 필요 없으니까 isvisted 필요 없을 거 같다!
			choose[idx]=arr[i];
			Solution(idx+1);
			
		}
	}
}
