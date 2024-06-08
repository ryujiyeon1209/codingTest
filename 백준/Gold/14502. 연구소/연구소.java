import java.util.*;

public class Main {
	
	static int[][] map;
	static int h, w, max, answer;
	static int[] r, c;
	static List<int[]> list;
	static int[] wall;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		max = h*w;
		
		list = new ArrayList();		//벽을 설치할 공간 후보들
		wall = new int[3];			//벽을 설치할 공간

		
		//연구실 정보 입력받기
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j]==0) list.add(new int[] {i, j}); 
			}
		}
		
		r = new int[] {1, 0, -1, 0};
		c = new int[] {0, -1, 0, 1};
		
		answer = 0;
		combination(0, 0);
		
		//출력
		System.out.println(answer);
	}
	
	//BFS
	public static void BFS() {
		
		boolean[][] isvisited = new boolean[h][w];	//방문 체크 배열
		Queue<int[]> queue = new LinkedList(); 		//바이러스가 있는 공간
		
		//임시 map 만들기
		int[][] tmp = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				tmp[i][j] =map[i][j];
				
				if(tmp[i][j]==2) {
					queue.add(new int[] {i, j});
					isvisited[i][j] = true;
				}
				
				else if(tmp[i][j]==1) isvisited[i][j] = true;
			}
		}
		
		//벽세우기
		for(int i=0; i<wall.length; i++) {
			int[] info = list.get(wall[i]);
			
			tmp[info[0]][info[1]] = 1;
			isvisited[info[0]][info[1]] = true;
		}
		
		while(!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
				else if(tmp[dr][dc]==1) continue;
				else if(isvisited[dr][dc]) continue;
				
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc});
			}
		}
		
		//안전한 공간 찾기
		int count = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(!isvisited[i][j]) count++;
			}
		}

		answer = Math.max(answer, count);
	} 
	
	//조합 
	public static void combination(int cur, int next) {
		
		if(list.size()<next) return;
		if(3<=cur) {
			
			BFS();
			return;
			
		} 
		
		wall[cur] = next;
		combination(cur+1, next+1);
		
		combination(cur, next+1);
	}
	
}
