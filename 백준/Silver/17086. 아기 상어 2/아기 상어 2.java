import java.util.*;

public class Main {
	
	static int h, w, answer;
	static int[][] map;
	static int[] r, c;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j]==1) map[i][j]=-1;
			}
		}

		r = new int[] {-1, 0, 1, 0, -1, 1, 1, -1};
		c = new int[] {0, 1, 0, -1, 1, 1, -1, -1};
		isvisited = new boolean[h][w];
		
		answer = 0;
		BFS();
		
		System.out.println(answer);
		
	}
	
	//BFS
	public static void BFS() {
		Queue<int[]> queue = new LinkedList();
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]==-1) {
					isvisited[i][j]=true;
					queue.add(new int[] {i, j, 0});
				}
			}
		}
		
		
		while(!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			int depth = cur[2];
			
			answer = Math.max(answer, depth);
		
			for(int k=0; k<8; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<h && 0<=dc && dc<w )) continue;
				if(map[dr][dc]==-1) continue;
				if(isvisited[dr][dc] &&  map[dr][dc]<=depth+1) continue;
				
				map[dr][dc]=depth+1;
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc, depth+1});
				
			}
		}
	}
}
