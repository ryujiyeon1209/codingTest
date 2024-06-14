import java.util.*;

public class Main {
	
	static int h, w, min;
	static int[] r, c;
	static int[][] map;
	static boolean[][][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		r = new int[] {0, 0, 1, -1};
		c = new int[] {1, -1, 0, 0};
		
		int[] start = new int[3];
		for(int i=0; i<3; i++) {
			start[i] = sc.nextInt()-1;
		}
		
		int[] end = new int[3];
		for(int i=0; i<3; i++) {
			end[i] = sc.nextInt()-1;
		}
		
		min = Integer.MAX_VALUE;
		isvisited = new boolean[4][h][w];
		BFS(start, end);
		
		//출력
		System.out.println(min);
	}
	
	//BFS
	public static void BFS(int[] start, int[] end) {
		Queue<int[]> queue = new LinkedList<>();
		
		isvisited[start[2]][start[0]][start[1]]=true;
		queue.add(new int[] {start[0], start[1], start[2], 0});
		
		while(!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			
			int i = cur[0];	
			int j = cur[1];
			int dir = cur[2];		//방향
			int depth = cur[3];		//길이
			
			if(i==end[0] && j==end[1] && dir==end[2]) {
				min = depth; 
                return;
			}

			//직진하기
			int dr = i;
			int dc = j;
			for(int k=0; k<3; k++) {
				dr +=r[dir];
				dc +=c[dir];
				
				//직진하는 경우에는 방문체크를 할 때 멈추지 않음 > 1칸 뒤는 방문했지만 3칸 뒤에는 방문하지 않았을 수도 있으므로 
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) break;
				if(map[dr][dc]==1) break;
				if(isvisited[dir][dr][dc]) continue;
				
				isvisited[dir][dr][dc]=true;
				queue.add(new int[] {dr, dc, dir, depth+1});
			}


			//방향 바꾸기
			if(dir==0 || dir==1) {
				if(!isvisited[2][i][j]) {
					isvisited[2][i][j]=true;
					queue.add(new int[] {i, j, 2, depth+1});
				}

				if(!isvisited[3][i][j]) {
					isvisited[3][i][j]=true;
					queue.add(new int[] {i, j, 3, depth+1});
				}
			}

			if(dir==2|| dir==3) {
				if(!isvisited[0][i][j]) {
					isvisited[0][i][j]=true;
					queue.add(new int[] {i, j, 0, depth+1});
				}

				if(!isvisited[1][i][j]) {
					isvisited[1][i][j]=true;
					queue.add(new int[] {i, j, 1, depth+1});
				}
			}
			
		}
	}	
}
