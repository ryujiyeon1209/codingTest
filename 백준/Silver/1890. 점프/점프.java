import java.util.*;

public class Main {
	
	static int n, answer;
	static int[] r, c;
	static int[][] map;
	static long[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();				
			}
		}
		
		r = new int[] {1, 0};
		c = new int[] {0, 1};
		
		dp = new long[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j] = -1;				
			}
		}
		
		answer = 0;
		DFS(0, 0);

		System.out.println(dp[0][0]);
	}
	
	//DFS
	public static long DFS(int i, int j) {
		
        //도착점에 도착한다면,
		if(i==n-1 && j==n-1) return 1; 
		
		//더 이상 갈 수 없다면,
		if(map[i][j]==0) return 0;
		
		
		//이미 지나간 경로라면,
		if(dp[i][j]!=-1) return dp[i][j];
		
		//지나간 적 없다면,
		dp[i][j] = 0;
		for(int k=0; k<2; k++) {
			int dr = i+(map[i][j]*r[k]);
			int dc = j+(map[i][j]*c[k]);
			
			if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
			
			dp[i][j]+=DFS(dr, dc);

		}
		
		return dp[i][j];
	}
}
