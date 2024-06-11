import java.util.*;

public class Main {
	
	static int h, w, answer;
	static int[] r, c;
	static char[][] map;
	static boolean[][] isvisitied;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		map = new char[h][w];
		for(int i=0; i<h; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		r = new int[] {1, 0, -1, 0};
		c = new int[] {0, -1, 0, 1};
		
		answer = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				isvisitied = new boolean[h][w];
				if(map[i][j]=='L') BFS(new int[] {i, j, 0});
			}
		}
	
		//출력
		System.out.println(answer);
		
	}
	
    //BFS
	public static void BFS(int[] location) {
		Queue<int[]> queue = new LinkedList();
		
		isvisitied[location[0]][location[1]]=true;
		queue.add(location);
		
		int max = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			int depth = cur[2];
			
			max = Math.max(max, depth);
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
				if(map[dr][dc]=='W') continue;
				if(isvisitied[dr][dc]) continue;
				
				
				isvisitied[dr][dc] = true;
				queue.add(new int[] {dr, dc, depth+1});
			}
		}
		
		answer = Math.max(answer, max);
	}
}
