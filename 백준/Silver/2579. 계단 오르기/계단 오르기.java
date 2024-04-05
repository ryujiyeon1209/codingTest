import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] dp = new int[2][n+3];
		
		for(int i=3; i<n+3; i++) {
			dp[0][i] = sc.nextInt();
		}
		
		for(int i=3; i<n+3; i++) {
			int type1 = dp[0][i]+dp[0][i-1]+dp[1][i-3];	//한 칸 + 세 칸
			int type2 = dp[0][i]+dp[1][i-2];			//두 칸
			
			dp[1][i] = Math.max(type1, type2);
		}
		
		//출력
		System.out.println(dp[1][n+2]);
	}
}
