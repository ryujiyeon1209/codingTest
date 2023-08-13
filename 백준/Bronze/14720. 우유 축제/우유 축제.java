import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//dp 배열 만들기
		int[][] dp= new int[3][n+1];
		for(int i=1; i<dp[0].length; i++) {
			dp[0][i]=sc.nextInt();
		}
		
		// 0 : 가게에서 파는 우유 종류
		// 1 : 지금 마신 우유 종류 > 다음에 마실 우유 종류 예측을 위해!
		// 2 : 마신 우유 개수
		
		dp[1][0]= -1;
		for(int i=1; i<dp[0].length; i++) {
			
			//다음에 먹어야 하는 우유 종류 계산
			int type=(dp[1][i-1]+1)%3;
			
			//가게의 종류가 다음에 먹을 우유와 같다면
			if(dp[0][i]==type) {
				dp[1][i] = dp[0][i];
				dp[2][i] = dp[2][i-1]+1;
			}
			
			//가게의 종류가 다음에 먹을 우유와 다르다면
			else {
				dp[1][i] = dp[1][i-1];
				dp[2][i] = dp[2][i-1];
			}
		}
		
		//출력
		System.out.println(dp[2][n]);
	}
}
