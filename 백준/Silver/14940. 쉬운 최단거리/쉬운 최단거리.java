import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] isvisited;
	static int[] r, c;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		//배열 크기 입력받기
		n = sc.nextInt();
		m = sc.nextInt();
		
		//시작 좌표
		int[] start=new int[3];
		
		//배열 생성 및 값 입력받기
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
				
				if(map[i][j]==2) { start[0]=i; start[1]=j; } 
			}
		}
		
		//방문체크 겸 정답 배열
		isvisited= new boolean[n][m];
		
		//사방탐색
		r = new int[] {-1, 0, 1, 0};
		c = new int[] {0, 1, 0, -1};
		
		//메서드 호출
		BFS(start);
		
		StringBuilder sb = new StringBuilder();

		//갈수 없는 부분 -1로 바꾸기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!isvisited[i][j] && map[i][j]==1) map[i][j]=-1;
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		//출력
		System.out.println(sb.toString());
	}
	
	
	//BFS
	public static void BFS(int[] location) {
		
		//큐 생성
		Queue<int[]> queue = new LinkedList();
		queue.add(location);
		
		//시작점 0으로 바꾸기
		map[location[0]][location[1]]=0;
		isvisited[location[0]][location[1]]=true;
		
		
		while(!queue.isEmpty()) {
			
			//현재 좌표
			int[] curr = queue.poll();
			
			int i = curr[0];
			int j = curr[1];
			int depth = curr[2];
			
			//사방탐색
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				//조건 검사
				if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
				if(isvisited[dr][dc]) continue;
				if(map[dr][dc]!=1) continue;
				
				//방문체크하고 map에 거리 값을 담기
				isvisited[dr][dc]=true;
				map[dr][dc]=depth+1;
				queue.add(new int[] {dr, dc, depth+1});
			}
			
		}

	}
}
