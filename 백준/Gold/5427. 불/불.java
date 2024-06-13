import java.util.*;

public class Main {
	
	static int h, w, min;
	static boolean flag;
	static int[] r, c;
	static int[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=0; t<test; t++) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				char[] ch = sc.next().toCharArray();
				for(int j=0; j<ch.length; j++) {
					if(ch[j]=='.') map[i][j]=0;
					else if(ch[j]=='#') map[i][j]=-1;	//벽
					else if(ch[j]=='*') map[i][j]=-10;	//불
					else if(ch[j]=='@') map[i][j]=100;	//사람
				}
			}
			
			r = new int[] {1, 0, -1, 0};
			c = new int[] {0, -1, 0, 1};
			
			isvisited = new boolean[h][w];
			flag = false;
			min = 0;
			BFS();
			
			//출력
			if(flag) System.out.println(min);
			else System.out.println("IMPOSSIBLE");
		}
	}
	
	//BFS
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]==100) {
					isvisited[i][j]=true;
					queue.add(new int[] {i, j, 1, 0});
				}
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]==-10) {
					queue.add(new int[] {i, j, 0, 0});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			int isFire = cur[2];
			int depth = cur[3];
            
            //사람이었는데 불에 휩싸였다면
            if(isFire==1 && map[i][j]==-10) continue;
		
            //사방탐색
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				//사람일때
				if(isFire==1) {
					if(!(0<=dr && dr<h && 0<=dc && dc<w)) {
						min = depth+1;
						flag=true;
						queue.add(new int[] {dr, dc, 1, depth+1});
						return;
					}
					
					if(map[dr][dc]==-1) continue;
					if(map[dr][dc]==-10) continue;
					if(isvisited[dr][dc]) continue;
	
					map[i][j]=0;
					map[dr][dc]=100;
					isvisited[dr][dc]=true;
					queue.add(new int[] {dr, dc, 1, depth+1});
				}
				
				//불일때
				else if(isFire==0) {
					if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
					if(map[dr][dc]==-1) continue;
					if(map[dr][dc]==-10) continue;
					
					map[dr][dc]=-10;
					queue.add(new int[] {dr, dc, 0, 0});
				} 
			}
		}
	}
}
