import java.util.*;

public class Main {
	
	static int h, w, count, total;
	static int[] r, c;
	static int[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		total = 0;	//치즈의 총량
		
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j]==1) total++;
			}
		}
		
		r = new int[] {1, 0, -1, 0};
		c = new int[] {0, -1, 0, 1}; 
		
		count = 0;				//치즈가 없어지기까지 횟수
		int cheese = 0;			//가장 작은 치즈의 크기
		
		//치즈 작아지기
		while(0<total) {
			count++;
			
			isvisited = new boolean[h][w];
			BFS();
		}
		
		//치즈가 사라지기 한시간 전 크기 재기
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]==(count*-1)) cheese++;
			}
		}
		
		//출력
		System.out.println(count);
		System.out.println(cheese);
	}
	
	//BFS
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		
		isvisited[0][0]=true;
		queue.add(new int[] {0, 0});
		
		while(!queue.isEmpty()) {

			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
				if(isvisited[dr][dc]) continue;
				
				if(map[dr][dc]==1) {			//치즈가 공기 만났을 때
					isvisited[dr][dc]=true;
					map[dr][dc]=-1*count;
					total--;
					continue;
				}

				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc});
			
			}
		}
	}
}
