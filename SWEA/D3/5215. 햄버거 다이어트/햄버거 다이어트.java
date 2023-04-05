import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int n, limitCal, scoreMax;
	static boolean[] isvisited;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			n = sc.nextInt();			//재료의 수
			limitCal = sc.nextInt();	//제한 칼로리
			
			//재료에 대한 점수와 칼로리를 담을 배열 생성 및 값 입력받기
			arr = new int[n][2];	
			for(int i=0; i<n; i++) {
				int score = sc.nextInt();	//맛에 대한 점수
				int cal = sc.nextInt();		//칼로리
				
				arr[i][0] = score;
				arr[i][1] = cal;
			}
			
			//선택 확인 배열
			isvisited = new boolean[n];
			
			scoreMax=0;
			
			subset(0);
			
			//출력
			System.out.printf("#%d %d\n", (t+1), scoreMax);
			
		}
	}
	
	//재료 n개 중 0~n개 고르기 > 순서 영향X > 중복X > 부분집합
	public static void subset(int idx) {
		
		if(idx==n) {
			
			int scoredSum=0; int calSum=0;
			
			//선택한 재료의 칼로리와 점수를 각각 더하기
			for(int i=0; i<isvisited.length; i++) {
				if(isvisited[i]) {
					scoredSum+=arr[i][0];
					calSum+=arr[i][1];
					
					//칼로리의 합이 제한칼로리보다 높으면 재귀 멈추기
					if(calSum>limitCal) return;
				}
			}
			
			//맛에 대한 점수가 가장 높은 값을 찾기
			scoreMax = Math.max(scoredSum, scoreMax);
			return;
		}
		
		
		if(!isvisited[idx]) {
			
			isvisited[idx]=true;
			subset(idx+1);
			
			isvisited[idx]=false;
			subset(idx+1);
		}
		
	}
}
