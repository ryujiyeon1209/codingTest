import java.util.*;

public class Main {
	
	static int n, min, max;
	static int[] r, c;
	static int[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		//인구 차이 최소 최대
		min = sc.nextInt();
		max = sc.nextInt();
		
		//사방향 탐색
		r = new int[] {1, 0, -1, 0};
		c = new int[] {0, -1, 0, 1};

		//인구 수 입력받기
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//인구 이동 횟수
		int answer = 0;
		
		while(true) {
			
			boolean flag = false;
			isvisited = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(isvisited[i][j]) continue;	//인구 이동으로 방문하지 않은 곳
					if(BFS(i, j)) flag = true;		//이동이 가능한지 확인
				}
			}
			
			if(flag) answer++;
			else break; 
		}


		//출력
		System.out.println(answer);
	}
	
	//BFS
	public static boolean BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList();
		
		isvisited[x][y] = true;
		queue.add(new int[] {x, y});
		
		int sum = 0;                              //인구 수
		List<int[]> list = new LinkedList();    //인구 이동 구역 좌표 리스트
		
        while(!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			int i = cur[0];
			int j = cur[1];
			
			sum+=map[i][j];
			list.add(new int[] {i, j});
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				else if(isvisited[dr][dc]) continue;
				
				int dif = Math.abs(map[i][j]-map[dr][dc]);
				if(min<=dif && dif<=max) {
					isvisited[dr][dc] = true;
					queue.add(new int[] {dr, dc});
				}
			}
		}
		
        //인구 이동 없음
		if(list.size()==1) return false;
		
		//인구 이동 시키기
		int people = sum/list.size();
		for(int i=0; i<list.size(); i++) {
			map[list.get(i)[0]][list.get(i)[1]] = people;
		}
		
		return true;
		
	}
}
