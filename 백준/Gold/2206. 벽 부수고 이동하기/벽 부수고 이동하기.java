import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, m, chance, result;
	static int[] r, c;
	static int[][] map, isvisited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//배열 크기 값 입력받기
		n = sc.nextInt();
		m = sc.nextInt();
		
		//공사 횟수와 방문처리를 모두 나타내는 배열
		isvisited = new int[n][m];
		
		
		//지도 배열 생성 및 값 입력받기
		map = new int[n][m];
		for(int i=0; i<map.length; i++) {
			String str = sc.next();
			for(int j=0; j<map[0].length; j++) {
				map[i][j]=str.charAt(j)-'0';
				isvisited[i][j]=Integer.MAX_VALUE;	//방문배열 모두를 무한대로 초기화
			}
		}
		
		
		//상하좌우 배열
		r = new int[] {0, 1, 0, -1};
		c = new int[] {1, 0, -1, 0};
		
		//0,0에서 출발
		result=-1;
		BFS(new int[] {0, 0, 1, 0});
		
		//정답 출력
		System.out.println(result);
		
	}
	
	//벽 뚫는 BFS
	public static void BFS(int[] location) {
		
		result=-1;
		
		//큐 생성 
		queue = new LinkedList();
		
		//큐에 출발 좌표 넣고, 방문처리 해주기
		queue.offer(location);
		
		//여기서 isvisited배열은 방문처리와 공사횟수의 2가지 의미를 가지게 된다.
		isvisited[location[0]][location[1]]=0;
		
		Outer:
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int i = curr[0];		//행 좌표
			int j = curr[1];		//열 좌표
			int depth = curr[2];	//탐색 횟수
			int isDril = curr[3];	//벽을 뚫은 적 있는지 없는지 확인하는 변수
			
			//현재 뽑은 좌표가 출구라면 반복문 그만하기!
			if(i==n-1 && j==m-1) {result=depth; break Outer;}
			
			for(int k=0; k<4; k++) {	//사방탐색
				
				int dr = i+r[k];
				int dc = j+c[k];
				
				//조건1
				if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
				
				//조건2
				//공사 여부와 상관 없이 isvisited배열 값이 공사 횟수보다 크다면, 방문하지 않은 곳이 된다.
				
				//예1) dril값이 0일 때 방문한 적 없는 벽에 도착하면, isvisited 값은 무한대이므로 통과
				//예2) dril값은 1일 때 방문한 적 없는 벽에 도착하면, isvisited 값은 무한대이므로 통과
				
				//예3) dril값이 0일 때 방문한 적 있는 벽에 도착하면, isvisited 값은 1이므로 통과
				//예4) dril값이 1일 때 방문한 적 있는 벽에 도착하면, isvisited 값은 1이므로 통과X
				
				//예5) dril값이 0일 때 방문한 적 없는 통로에 도착하면, isvisited 값이 무한대이므로 통과
				//예6) dril값이 1일 때 방문한 적 없는 통로에 도착하면, isvisited 값이 무한대이므로 통과 
				
				//예7) dril값이 0일 때 방문한 적 있는 통로에 도착하면, isvisited 값이 0 또는 1이므로 통과 또는 통과X
				//예8) dril값이 1일 때 방문한 적 있는 통로에 도착하면, isvisited 값이 0 또는 1이므로 통과X
				
				if(isvisited[dr][dc]<=isDril) continue;				
				
				//벽을 만났을 때
				if(map[dr][dc]==1) {
					//isDril이 0이면 이번 루트에서 공사한 적 없다!
					//공사가 진행되었다고, isDril과 isvisited 값을 +1로 바꿔준다.
					if(isDril==0) {
						isvisited[dr][dc]=isDril+1;
						queue.offer(new int[] {dr, dc, depth+1, isDril+1});
					}
				}
				
				//벽이 아닌 통로를 만났을 때
				else if(map[dr][dc]==0) {
					
					//isvisited에 여태까지 이번 루트에서 내가 공사 몇 번하고 여기까지 왔는지 담기
					isvisited[dr][dc]=isDril;
					queue.offer(new int[] {dr, dc, depth+1, isDril});
					
				}
			}
		}
	}
}