import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int h, w, countCheck;
	static int[][] map, countMap;
	static boolean[][] isvisited;
	static int[] r, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		//2차원 배열 생성 및 값 입력받기
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		r = new int[] {-1, 0, 1, 0};	
		c = new int[] {0, 1, 0, -1};
		
		int result=0;
		
		do {
			
			countCheck =0; //빙산 개수
			isvisited = new boolean[h][w];		//방문체크 배열
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(0<map[i][j] && !isvisited[i][j]) {
						countCheck++;
						BFS(new int[] {i, j});
					}
				}
			}

			if(countCheck==0) { result=1; break; }
			else result++;
		} while(countCheck < 2);
		
		//출력
		System.out.println(result-1);
	}
	
	
	public static void BFS(int[] location) {

		Queue<int[]> queue = new LinkedList();
		queue.add(location);
		isvisited[location[0]][location[1]]=true;
		
		countMap = new int[h][w];
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			int i = curr[0];
			int j = curr[1];
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
				if(map[dr][dc]==0) {
					countMap[i][j]+=1;
					continue;
				}
				
				if(isvisited[dr][dc]) continue;
				isvisited[dr][dc] = true;
				queue.add(new int[] {dr, dc});
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = (countMap[i][j]<map[i][j]) ? map[i][j]-countMap[i][j] : 0 ;
			}
		}
	}
}
