import java.util.*;

public class Main {
	
	static boolean flag;
	static int h, w, min;
	static int[] r, c;
	static char[][] map;
	static boolean[][][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		map = new char[h][w];
		for(int i=0; i<h; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		r = new int[] {0, 0, 1, -1};
		c = new int[] {1, -1, 0, 0};
		isvisited = new boolean[2][h][w];
		
		min=0;
		flag=false;
		BFS();
		
		//출력
		if(flag) System.out.println(min);
		else System.out.println("KAKTUS"); 
	}
	
	//BFS
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		
		int[] finish = new int[2];
		
		//물 위치 찾기
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]=='*') {
					isvisited[1][i][j] = true;
					queue.add(new int[] {i, j, 1, 0});
				}
			}
		}
		
		//고슴도치 위치와 비버의 굴 위치 찾기
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]=='S') {
					isvisited[0][i][j] = true;
					queue.add(new int[] {i, j, 0, 0});
				}
				
				if(map[i][j]=='D') {
					finish[0]=i;
					finish[1]=j;
				}
			}
		}
		
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			int isWater = cur[2];
			int depth = cur[3];
			
			if(isWater==0 && i==finish[0] && j==finish[1]) {
				flag = true;
				min = depth;
				return;
			}
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
				if(map[dr][dc]=='X') continue;
				
				//물일 때
				if(isWater==1) {
					if(map[dr][dc]=='D') continue;
					if(isvisited[1][dr][dc]) continue;
					
					map[dr][dc]='*';
					isvisited[1][dr][dc]=true;
					queue.add(new int[] {dr, dc, 1, 0});
				}
				
				//고슴도치일때
				if(isWater==0) {
					if(map[dr][dc]=='*') continue;
					if(isvisited[0][dr][dc]) continue;
					
					
					map[i][j]='.';
					map[dr][dc]='S';
					isvisited[0][dr][dc]=true;
					queue.add(new int[] {dr, dc, 0, depth+1});
				}
			}
		}
	}
}
