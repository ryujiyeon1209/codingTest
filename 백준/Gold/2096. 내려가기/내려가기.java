import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
        //기본값 저장
		int[][] dp = new int[n][3];
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		
		int[][] min = new int[n][3];
		int[][] max = new int[n][3];
		for(int j=0; j<3; j++) {
			min[0][j] = dp[0][j];
			max[0][j] = dp[0][j];
		}
		
        //dp
		for(int i=1; i<n; i++) {
			for(int j=0; j<3; j++) {
				if(j==0) min[i][j] = Math.min(min[i-1][j], min[i-1][j+1])+dp[i][j];
				else if(j==1) min[i][j] = Math.min(min[i-1][j-1], Math.min(min[i-1][j], min[i-1][j+1]))+dp[i][j];
				else min[i][j] = Math.min(min[i-1][j], min[i-1][j-1])+dp[i][j];
				
				if(j==0) max[i][j] = Math.max(max[i-1][j], max[i-1][j+1])+dp[i][j];
				else if(j==1) max[i][j] = Math.max(max[i-1][j-1], Math.max(max[i-1][j], max[i-1][j+1]))+dp[i][j];
				else max[i][j] = Math.max(max[i-1][j], max[i-1][j-1])+dp[i][j];
			}
		}
		
        //최소값 최대값 찾기
		int minan = Math.min(min[n-1][0], Math.min(min[n-1][1], min[n-1][2]));
		int maxan = Math.max(max[n-1][0], Math.max(max[n-1][1], max[n-1][2]));
		
		
		//출력
		System.out.println(maxan + " " + minan);
	}
}
