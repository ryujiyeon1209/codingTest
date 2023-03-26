
import java.util.Scanner;

public class Solution {
	
	static int n, k, sum, count;
	static int[] arr;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			n = sc.nextInt();	//숫자들 개수
			k = sc.nextInt();	//고른 숫자들을 더해서 나와야 하는 값
			
			arr= new int[n];
			for(int i=0; i<arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			
			isvisited = new boolean[n];	//숫자 선택 여부 확인 배열
			
			count=0;
			subsequence(0);
			
			System.out.printf("#%d %d\n", (t+1), count);	//출력
			
		}
	}
	
	//n개의 숫자 중 0~n개를 고르기 > 순서 영향X > 부분집합
	public static void subsequence(int idx) {
		
		if(idx==n) {	//끝까지 탐색했다면
			
			sum=0;	//고른 숫자들의 합
			for(int i=0; i<isvisited.length; i++) {
				if(isvisited[i]) sum+=arr[i];
			}
			
			if(sum==k) count++;
			return;
		}
		
		
		if(!isvisited[idx]) {
			
			//인덱스 idx를 선택하고 다음으로 넘어가기
			isvisited[idx]=true;
			subsequence(idx+1);
			
			//인덱스 idx를 취소하고 다음으로 넘어가기
			isvisited[idx]=false;
			subsequence(idx+1);
		}
	}
}
