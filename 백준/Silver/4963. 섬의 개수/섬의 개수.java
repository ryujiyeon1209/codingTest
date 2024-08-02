import java.util.*;

public class Main {
	
	static int n, m;
	static int[] r, c;
	static int[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		
		r = new int[] {-1, 1, 0, 0, -1, -1, 1, 1};
		c = new int[] {0, 0, -1, 1, -1, 1, -1, 1};
		
		StringBuilder sb = new StringBuilder();
		while(n!=0 && m!=0){
			
			map = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			isvisited = new boolean[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==1 && !isvisited[i][j]) {
						answer++;
						BFS(n, m, i, j);
					}
				}
			}
		
			sb.append(answer+ "\n");
			
			//다음 섬 크기
			m = sc.nextInt();
			n = sc.nextInt();
		} 
		
		//출력
		System.out.println(sb.toString());
	}
	
	//BFS
	public static void BFS(int n, int m, int x, int y) {
		Queue<int[]> queue = new LinkedList();
		
		isvisited[x][y]=true;
		queue.add(new int[] {x, y});

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			
			for(int k=0; k<8; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
				if(map[dr][dc]==0) continue;
				if(isvisited[dr][dc]) continue;
				
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc});
			}
		}
	}
}
