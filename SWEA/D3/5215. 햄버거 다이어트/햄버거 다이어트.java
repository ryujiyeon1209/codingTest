import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			int n = sc.nextInt();			//재료의 개수
			int limitCal = sc.nextInt();	//제한 칼로리
			
			int[] score = new int[n+1];		//맛에 대한 점수 배열
			int[] cal = new int[n+1];		//칼로리에 대한 점수 배열
			
			//값 입력받기
			for(int i=1; i<=n; i++) {
				score[i]=sc.nextInt();
				cal[i]=sc.nextInt();
			}
			
			
			int[][] dp = new int[n+1][limitCal+1];	//dp배열 생성
			
			for(int i=1; i<n+1; i++) {				//재료 하나씩 더한 것에 대한 반복문
				for(int j=0; j<limitCal+1; j++) {	//재료 하난에 칼로리를 계산 한 것
					
					if(cal[i]<=j) {			//현재 제한칼로리가 이 재료의 칼로리보다 높다면
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cal[i]]+score[i]);
					}
					
					else {					//현재 제한 칼로리가 이 재료의 칼로리보다 낮다면
						dp[i][j]=dp[i-1][j];
					}
				}
			}
			
			//출력
			System.out.printf("#%d %d\n", (t+1), dp[n][limitCal]);
			
		}
	}
}
