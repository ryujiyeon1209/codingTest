import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, startR, startC, endR, endC, depth;
	static int[][] map;
	static boolean[][] isvisited;
	static int[] r, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			n = sc.nextInt();
			map = new int[n][n];	
			
			//방문체크 배열
			isvisited = new boolean[n][n];
			
			//시작 좌표
			startR = sc.nextInt();
			startC = sc.nextInt();
			
			//도착좌표
			endR = sc.nextInt();
			endC = sc.nextInt();
			
			//팔방탐색
			r = new int[] {-1, -2, -1, -2, 1, 2, 1, 2};
			c = new int[] {-2, -1, 2, 1, -2, -1, 2, 1};
			
			//매서드 실행 및 출력
			BFS(new int[] {startR, startC, 0});
			System.out.println(depth);
		}
	}
	
	public static void BFS(int[] location) {
		
		//큐 생성 및 초기화
		Queue<int[]> queue = new LinkedList();
		isvisited[location[0]][location[1]]=true;
		queue.add(location);
		
		while(!queue.isEmpty()) {
			
			//현재 좌표
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			depth = curr[2];
			
			if(cr==endR && cc==endC) {return;}
			
			//팔방 탐색
			for(int k=0; k<8; k++) {
				
				int dr = cr+r[k];
				int dc = cc+c[k];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				if(isvisited[dr][dc]) continue;
				
				queue.offer(new int[] {dr, dc, depth+1});
				isvisited[dr][dc]=true;
				
			}
		}
	}
}
