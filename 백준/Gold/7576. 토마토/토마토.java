import java.util.*;

public class Main {
	
	static int w, h, answer;
	static int[] r, c;
	static int[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		w = sc.nextInt();
		h = sc.nextInt();
		
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		r = new int[]{-1, 0, 1, 0};
		c = new int[]{0, 1, 0, -1};
		isvisited = new boolean[h][w];
		
	
		answer = 0;
		BFS();
		
		System.out.println(answer);
		
	}
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList();
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]==1) {
					map[i][j]=-10;
					isvisited[i][j]=true;
					queue.add(new int[] {i, j, 0});
				}
			}
		}
		
		//사방탐색
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int i = curr[0];
			int j = curr[1];
			int day = curr[2];
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
				if(map[dr][dc]!=0) continue;
				if(isvisited[dr][dc]) continue;
				
				map[dr][dc]=day+1;
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc, day+1});
			}
		}
		
		//모든 토마토가 익을 수 있는지 계산하기
		Loop:
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]==0) {
					answer=-1;
					break Loop;
				}
				
				else if(answer<map[i][j]) {
					answer=map[i][j];
				}
			}
		}
	}
	

}
