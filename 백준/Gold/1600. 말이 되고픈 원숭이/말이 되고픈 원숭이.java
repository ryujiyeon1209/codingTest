import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	static int chance, n, m, min;
	static int[] r, c;
	static int[][] map;
	static boolean[][][] isvisited;
//	static Queue<Monkey> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		chance = Integer.parseInt(br.readLine());	//점프할 수 있는 횟수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());	//열
		n = Integer.parseInt(st.nextToken());	//행
		
		//여행길 배열 생성 및 값 입력받기, 방문처리 배열 초기화
		map = new int[n][m];
		isvisited = new boolean[n][m][chance+1];
		for(int i=0; i<n; i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}

		//말처럼 뛰어다닐 수 있는 좌표 탐색
		r= new int[] {0, 1, 0, -1, -2, -2, -1, -1, 2, 2, 1, 1};
		c= new int[] {1, 0, -1, 0, -1, 1, -2, 2, -1, 1, -2, 2};
		
		min=-1;
		BFS();
		
		//출력
		bw.write(String.valueOf(min));
		bw.close();
		br.close();
		
	}
	
	
	public static void BFS() {
		
		//큐 생성
		 Queue<Monkey> queue = new LinkedList<Monkey>();
		 queue.offer(new Monkey(0, 0, 0, 0));
		
		//큐에 넣고 방문처리
		isvisited[0][0][0]=true;
		
		Outer:
		while(!queue.isEmpty()) {
			
			Monkey curr = queue.poll();
			
			int i = curr.x;		//행
			int j = curr.y;		//열
			int jump = curr.jump;		//말처럼 뛴 점프 횟수
			int depth = curr.depth;	//탐색 횟수
			
			if(i==n-1 && j==m-1) { min=depth; break Outer; }
			

			for(int k=0; k<12; k++) {
				
				int dr = i+r[k];
				int dc = j+c[k];
				
				//조건1. 인덱스 범위
				if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
				
				//조건2. 장애물이면 넘어가기
				if(map[dr][dc]==1) continue;
				
				//조건3. 말처럼 뛰려고 하는데 찬스를 다쓰면 넘어가기
				if(k>=4 && jump>=chance) continue;
				
				//조건4. 말처럼 뛰려고 하는데 방문한 적 있으면 넘어가기
				if(k>=4 && isvisited[dr][dc][jump+1]) continue;

				//조건5. 인접한 곳을 가려고 하는데 이미 방문한 곳이면 넘어가기
				if(k<4 && isvisited[dr][dc][jump]) continue;
				
				//경우의 수1. 인접한 곳을 가기!
				if( k<4) {
					isvisited[dr][dc][jump]=true;						//방문처리
					queue.offer(new Monkey (dr, dc, jump, depth+1));	//큐에 넣기				
				}
				
				
				//경우의 수2. 말처럼 뛰기!
				if( jump<chance && 4<=k) {
					isvisited[dr][dc][jump+1]=true;						//방문처리
					queue.offer(new Monkey (dr, dc, jump+1, depth+1));	//큐에 넣기
				}
					
			}
		}
	}
}

class Monkey{
	int x;
	int y;
	int jump;
	int depth;
	
	
	public Monkey(int x, int y, int jump, int depth) {
		this.x = x;
		this.y = y;
		this.jump = jump;
		this.depth = depth;
	}
}

//jump가 1보다 크고 값이 0이라면, 점프를 한 적이 있고, 이 좌표 처음이야
//jump가 1보다 크고 값이 1이라면, 점프를 한 적이 있고, 이 좌표 방문한 루트 있어
//jump가 0이고 값이 0이라면, 점프를 한 적 없고, 좌표 처음이야
//jump가 0이고 값이 1이라면, 점프를 한 적 없고, 이 좌표 방문한 루트가 있어