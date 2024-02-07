import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		
		for(int t=0; t<test; t++) {
			
			int n = sc.nextInt();
			
			int[][] arr = new int[2][n+2];
			for(int i=0; i<2; i++) {
				for(int j=2; j<n+2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			//점화식
			int[][] dp = new int[2][n+2];
			for(int i=2; i<n+2; i++) {
				for(int j=0; j<2; j++) {
					int k = (j==0) ? 1 : 0; 
					dp[j][i] = Math.max(dp[k][i-1], dp[k][i-2]) + arr[j][i];
				}
			}
			
			//출력
			System.out.println(Math.max(dp[0][n+1], dp[1][n+1]));
		}
	}
}
