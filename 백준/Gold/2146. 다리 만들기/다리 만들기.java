import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, result, min;
	static int[] r, c;
	static int[][] map;
	static boolean[][] isvisited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//지도 배열 크기 입력받기
		n = sc.nextInt();

		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		//사방탐색 배열
		r = new int[] {0, 1, 0, -1};
		c = new int[] {1, 0, -1, 0};
		
		//방문 체크 배열
		isvisited = new boolean[n][n];
		
		//BFS_NUM을 실행해보자!
		int num=1;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j]==1 && !isvisited[i][j]) {
					BFS_NUM(new int[] {i, j}, num);
					num++;
				}
			}
		}

		
		
		//최소값 비교 변수
		min = Integer.MAX_VALUE;
		
		//BFS를 실행해보자!
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j]!=0) {
					
					//방문 체크 배열 초기화
					isvisited = new boolean[n][n];
					
					BFS(new int[] {i, j, 0}, map[i][j]);
					
					//최소값 찾기
					if(result<min) min=result;

				}
			}
		}

		//섬에 도착하기 전에 다리가 끝나니까 -1 해주기!
		System.out.println(min-1);
	}
	
    
	//섬에 번호 매기는 메서드
	public static void BFS_NUM(int[] location, int num) {
		
		//큐 생성
		queue = new LinkedList();
		
		//큐에 넣고 방문처리하기
		queue.add(location);
		isvisited[location[0]][location[1]]=true;
		
		while(!queue.isEmpty()) {
			
			//현재 좌표
			int[] curr = queue.poll();
			
			int i = curr[0];
			int j = curr[1];
			
			//큐에서 빠져나왔다는 것은 이 좌표가 현재 탐색 중인 섬에 속한 땅이라는 것!
			map[i][j]=num;
			
			//사방 탐색
			for(int k=0; k<4; k++) {
				
				int dr = i+r[k];
				int dc = j+c[k];
				
				//조건1. 인덱스 범위 확인하기
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				
				//조건2. 방문한 적 있는지 확인하기
				if(isvisited[dr][dc]) continue;
				
				//조건3. 섬인지 확인하기
				if(map[dr][dc]==0) continue;
				
				//조건에 맞는다면 큐에 넣기
				queue.offer(new int[] {dr, dc});
				isvisited[dr][dc]=true;
				
			}
		}
	}
	
	public static void BFS(int[] location, int island) {
		
		boolean flag = false;
		
		//큐 생성
		queue = new LinkedList();
		
		//큐에 넣고 방문처리하기
		queue.add(location);
		isvisited[location[0]][location[1]]=true;
		
		Outer:
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			//현재 좌표
			int i = curr[0];
			int j = curr[1];
			int depth = curr[2];
			
			
			if(map[i][j]!=0 && map[i][j]!=island) { flag = true; result=depth; break Outer;}
			
			//사방탐색
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				//조건1. 인덱스 범위 확인하기
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				
				//조건2. 방문한적 있는지 확인하기
				if(isvisited[dr][dc]) continue;
				
				//조건3. 같은 섬인지 확인하기
				if(map[dr][dc]==island) continue;
				
				//조건에 맞는다면 큐에 넣고 방문처리하기
				queue.add(new int[] {dr, dc, depth+1});
				isvisited[dr][dc]=true;
			}
			
		}
		
		//섬 찾기 실패했으면  result는 무한대다
		if(!flag) result = Integer.MAX_VALUE;
		
	}
}
