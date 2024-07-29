import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int test = sc.nextInt();
		
		int[][] map = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[][] dp = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				int rp = 0;
				int cp = 0;
				int tp = 0;
				
				if(0<=i-1) rp = dp[i-1][j];
				if(0<=j-1) cp = dp[i][j-1];
				if(0<=i-1 && 0<=j-1) tp=dp[i-1][j-1];
				
				dp[i][j] = rp+cp-tp+map[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int t=0; t<test; t++) {
			int fr = sc.nextInt()-1;
			int fc = sc.nextInt()-1;
			
			int er = sc.nextInt()-1;
			int ec = sc.nextInt()-1;
			
			int cm = 0;
			int rm = 0;
			int tm = 0;
			
			if(0<=fc-1) cm = dp[er][fc-1];
			if(0<=fr-1) rm = dp[fr-1][ec];
			if(0<=fc-1 && 0<=fr-1) tm = dp[fr-1][fc-1];
			
			
			sb.append((dp[er][ec]-cm-rm+tm)/((er-fr+1)*(ec-fc+1))+ "\n");
		}
		
		//출력
		System.out.println(sb.toString());
	}
}
