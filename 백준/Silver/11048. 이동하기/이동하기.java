import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정보 입력받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
        //dp 배열 생성
		int[][] dp = new int[n][m];
		
		//dp 계산
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				//위, 대각선, 왼쪽 모두 범위 밖일 때
				if(i-1<0 && j-1<0) dp[i][j] = map[i][j];
				
				//위, 대각선이 범위 밖일 때
				else if(i-1<0 && 0<=j-1) dp[i][j] = map[i][j] + dp[i][j-1];
				
				//왼쪽, 대각선이 범위 밖일 때
				else if(0<=i-1 && j-1<0) dp[i][j] = map[i][j] + dp[i-1][j];
				
				//위, 대각선, 왼쪽 모두 범위 안쪽일 때
				else if(0<=i-1 && 0<=j-1) {
					int max = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
					dp[i][j] = map[i][j] + max;
				}
			
			}
		}
		
		//출력
		System.out.println(dp[n-1][m-1]);
		
	}
}
