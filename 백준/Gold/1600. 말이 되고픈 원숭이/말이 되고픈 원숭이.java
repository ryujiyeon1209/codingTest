import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int w, h, chance, result;
	static int[] r, c;
	static int[][] map;
	static boolean[][][] isvisited;
	static Queue<Monkey> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		chance = sc.nextInt();	//말처럼 뛸 수 있는 횟수

		w = sc.nextInt();	//열
		h = sc.nextInt();	//행
		
		
		//지도 배열 생성 및 값 입력받기
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		r = new int[] {0, 1, 0, -1, -1, -2, -1, -2, 1, 2, 1, 2};
		c = new int[] {1, 0, -1, 0, -2, -1, 2, 1, -2, -1, 2, 1};
		
		//방문처리 배열
		isvisited = new boolean[chance+1][h][w];
		
		
		//BFS시작하기
		result=-1;
		BFS(new Monkey (0,0,0,0));
		
		//정답 출력
		System.out.println(result);	
	}
	
	public static void BFS(Monkey location) {
		
		//큐생성
		queue = new LinkedList();
		
		//큐에 넣고 방문 처리
		queue.offer(location);
		isvisited[0][0][0]=true;
		
		while(!queue.isEmpty()) {
			
			//현재 좌표
			Monkey monkey = queue.poll();
			
			int i = monkey.x;
			int j = monkey.y;
			int jump = monkey.jump;
			int depth = monkey.depth;
			
			//출구면 BFS 멈추기!
			if(i==h-1 && j==w-1) {result=depth; return;}
			
				
			//사방 + 팔방탐색 
			for(int k=0; k<12; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				//조건1. 인덱스 범위 확인하기
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
				
				
				//조건2. 장애물인지 확인하기
				if(map[dr][dc]==1) continue;
				
				//경우의 수1. 원숭이처럼 뛰었을 때
				if(k<4) {

					//조건3. 방문 배열 확인하기
					if(isvisited[jump][dr][dc]) continue;
					
					isvisited[jump][dr][dc]=true;
					queue.offer(new Monkey(dr, dc, jump, depth+1));
				}
				
				//조건4. 말처럼 뛸 수 있는 찬스 확인하기  
				if(jump>=chance) {continue;}
				
				//경우의 수2. 말처럼 뛰었을 때
				if(4<=k) {
					
					//조건3. 방문 배열 확인하기
					if(isvisited[jump+1][dr][dc]) continue;
					
					isvisited[jump+1][dr][dc]=true;
					queue.offer(new Monkey(dr, dc, jump+1, depth+1));
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
		super();
		this.x = x;
		this.y = y;
		this.jump = jump;
		this.depth = depth;
	}
}
