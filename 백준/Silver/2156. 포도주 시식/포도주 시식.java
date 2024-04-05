import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//포도주 개수 입력받기
		int n = sc.nextInt();
		
		//dp배열 생성하기
		int[][] dp = new int[2][n+4];
		for(int i=4; i<n+4; i++) {
			dp[0][i] = sc.nextInt();
		}
		
		//현재 잔 + 현재 잔으로 오기까지 최대값 
		for(int i=4; i<n+4; i++) {
			int type = Math.max(dp[0][i-1]+dp[1][i-3], dp[1][i-2]);
			type = Math.max(type, dp[0][i-1]+dp[1][i-4]);
			
			dp[1][i] = dp[0][i] + type;
		}
		
		//최대값 구하기
		long max = 0;
		for(int i=0; i<n+4; i++) {
			if(max<dp[1][i]) max = dp[1][i];
		}
		
		//출력
		System.out.println(max);
	}
}
