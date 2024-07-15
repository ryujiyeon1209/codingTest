import java.util.*;

public class Main {
	
	static int n, m, count;
	static int[] r, c;
	static int[][] map, dp;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		r = new int[] {-1, 0, 1, 0};
		c = new int[] {0, -1, 0, 1};
		
		dp = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dp[i][j] = -1;
			}
		}
		
		DFS(new int[] {0, 0});
        
		System.out.println(dp[0][0]);
	}

	//DFS
	public static int DFS(int[] cur) {

		int i = cur[0];
		int j = cur[1];
		
		if(i==n-1 && j==m-1) return 1;		//목적지 도착했다면, 1로 갱신
		if(dp[i][j]!=-1) return dp[i][j];	//방문 기록 있다면, 기록 가져오기
		
		dp[i][j] = 0; // 방문한 적이 없다면 0으로 초기화
		
		for(int k=0; k<4; k++) {
			int dr = i+r[k];
			int dc = j+c[k];
			
			if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue; 
			if(map[i][j]<=map[dr][dc]) continue;

			dp[i][j]+=DFS(new int[] {dr, dc});

		}
		
		return dp[i][j];
	}
}
