import java.util.*;

public class Main {
	
	static int n, m, answer;
	static int[] r, c;
	static int[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=0; t<test; t++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int count = sc.nextInt();
			
			map = new int[n][m];
			for(int i=0; i<count; i++) {
				int dm = sc.nextInt();
				int dn = sc.nextInt();
				
				map[dn][dm]=1;
			}
			
			r = new int[] {-1, 1, 0, 0};
			c = new int[] {0, 0, -1, 1};
			
			isvisited = new boolean[n][m];
			
			answer = 0;
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					if(map[i][j]==1 && !isvisited[i][j]) {
						answer++;
						BFS(i, j);
					}
				}
			}
			
			System.out.println(answer);
		}
	}
	
	//BFS
	public static void BFS(int startr, int startc) {
		Queue<int[]> queue = new LinkedList();
		
		isvisited[startr][startc]=true;
		queue.add(new int[] {startr, startc});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
				if(isvisited[dr][dc]) continue;
				if(map[dr][dc]==0) continue;
				
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc});
			}
		}
	}
}
