
import java.util.Scanner;

public class Solution {
	
	static int n, k, height, min;
	static int[] arr, choose;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {

			n = sc.nextInt();	//직원들 수
			k = sc.nextInt();	//사다리 길이
			
			arr = new int[n];	//직원들 키 배열
			for(int i=0; i<arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			
			isvisited = new boolean[n];	//직원들 선택 여부 배열
			
			min = Integer.MAX_VALUE;
			subsequence(0);
			
			System.out.printf("#%d %d\n", (t+1), min);

		}
	}
	
	//숫자 n개 중 0~n개를 고르기 > 순서 영향X > 부분집합
	public static void subsequence(int idx) {
		
		//끝까지 탐색했으면 재귀 멈추기
		if(idx==n) {
			height=0;			
			for(int i=0; i<isvisited.length; i++) {
				if(isvisited[i]) height+=arr[i];
			}
			
			int distance = height-k;	//직원들 키의 합 - 사다리
			if(0<=distance) {
				min=Math.min(distance, min);
			}
			return;
		}
		
		if(!isvisited[idx]) {
			
			//지금 숫자 선택하고, 다음 숫자 보러 갈래
			isvisited[idx]=true;
			subsequence(idx+1);
			
			//지금 숫자 취소하고, 다음 숫자 보러 갈래
			isvisited[idx]=false;
			subsequence(idx+1);
		}
		
	}
}
