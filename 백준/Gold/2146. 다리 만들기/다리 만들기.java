import java.util.*;

public class Main {

	static int n, answer;
	static int[] r, c;
	static int[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer = Integer.MAX_VALUE;
		
		n = sc.nextInt();
		
		r = new int[] {-1, 1, 0, 0};
		c = new int[] {0, 0, -1, 1};
		
		map = new int[n][n];
		isvisited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//섬 구역 번호 붙이기
		int bridge = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && !isvisited[i][j]) {
					bridge++;
					BFS(i, j, bridge);
				}
			}
		}
		
		//최단 거리 다리 건설하기
		isvisited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]!=0 && !isvisited[i][j]) {
					isvisited[i][j]=true;
					BFS2(i, j, map[i][j]);
				}
			}
		}
		
		//출력
		System.out.println(answer);
		
	}
	
	//섬 구역 번호 붙이기
	public static void BFS(int si, int sj, int bridge) {
		Queue<int[]> queue = new LinkedList();
		
		map[si][sj] = bridge;
		isvisited[si][sj]=true;
		queue.add(new int[] {si, sj, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i= cur[0];
			int j= cur[1];
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				if(map[dr][dc]==0) continue;
				if(isvisited[dr][dc]) continue;
				
				map[dr][dc]=bridge;
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc});
			}
		}
	}
	
	//최단 거리 다리 건설하기
	public static void BFS2(int si, int sj, int bridge) {
		Queue<int[]> queue = new LinkedList();
		
		boolean flag = false;
		if(si==4 && sj==3) flag=true;
		
		boolean[][] tmpvisited = new boolean[n][n];
		tmpvisited[si][sj]=true;
		queue.add(new int[] {si, sj, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i= cur[0];
			int j= cur[1];
			int depth = cur[2];

			
			if(map[i][j]!=0 && map[i][j]!=bridge) {
				answer = Math.min(answer, depth-1);
			}
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				if(map[dr][dc]==bridge) continue;
				if(tmpvisited[dr][dc]) continue;
		
				tmpvisited[dr][dc]=true;		
				queue.add(new int[] {dr, dc, depth+1});
			}
		}
	}
}


//for(int i=0; i<map.length; i++) {
//	System.out.println(Arrays.toString(map[i]));
//}
//System.out.println("answer : " +answer);
//System.out.println("i : " +i+ ", j : " +j+ " > map : " +map[i][j]+ ", depth : "+depth);
//System.out.println("i : " +i+ ", j : " +j+ " > map : " +map[i][j] + " > map : " +map[dr][dc]);
