import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, m, chance, result;
	static int[] r, c;
	static int[][] map;
	static boolean[][][] isvisited;
	static Queue<int[]> queue;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//행
		m = sc.nextInt();	//열
		
		chance = sc.nextInt();	//벽을 부술 수 있는 기회
		
		//지도 배열 생성 및 값 입력받기
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = sc.next();	
			for(int j=0; j<m; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		//방문 체크 배열
		isvisited = new boolean[chance+1][n][m];
		
		r = new int[] {0, 1, 0, -1};
		c = new int[] {1, 0, -1, 0};
		
		//정답 변수
		result=-1;
		
		//BFS 시작! > 시작하는 칸도 포함되므로 depth를 1로 초기화
		BFS(new int[] {0,0,0,1});
		
		//출력
		System.out.println(result);
	}
	
	public static void BFS(int[] location) {
		
		//큐 생성
		queue = new LinkedList();
		
		//큐에 최초 좌표 넣고 방문처리하기
		queue.offer(location);
		isvisited[0][0][0]=true;
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int i =curr[0];
			int j =curr[1];
			int isDril =curr[2];
			int depth =curr[3];
			
			if(i==n-1 && j==m-1) { result=depth; return; }
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				//조건1. 인덱스 범위 확인하기
				if(!(0<= dr && dr<n && 0<=dc && dc<m)) continue;
				
				//조건2. 방문 체크 확인하기
				if(isvisited[isDril][dr][dc]) continue;
				
				//경우의 수1. 통로라면, 방문처리하고 큐에 넣기
				if(map[dr][dc]==0) {
					isvisited[isDril][dr][dc]=true;
					queue.offer(new int[] {dr, dc, isDril, depth+1});
				}
				
				//조건3. 만약 벽 부술 수 있는 찬스를 다 쓰면 그냥 넘어가기! 
				if(isDril>=chance) continue;
				
				//경우의 수2. 벽이라면, 공사를 한 후 큐에 넣기(여기까지 온 것은 찬스가 있다는 것!)
				if(map[dr][dc]==1) {
					isvisited[isDril][dr][dc]=true;
					queue.offer(new int[] {dr, dc, isDril+1, depth+1});
				}
				
			}
		}
		
		
	}
}
