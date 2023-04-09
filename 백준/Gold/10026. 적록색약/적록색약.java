import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] r,c;
	static char[][] board;
	static boolean[][] isvisited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//그림 배열 크기 입력받기
		n = sc.nextInt();
		
		//그림 배열 생성 및 값 입력받기
		board = new char[n][n];
		for(int i=0; i<board.length; i++) {
			String str = sc.next();
			board[i]=str.toCharArray();
		}
		
		//사방 탐색 배열
		r = new int[] {0, 1, 0, -1};
		c = new int[] {1, 0, -1, 0};		

		//방문기록 배열
		isvisited = new boolean[n][n];
		
		//적록색약X > 방문하지 않았다면 BFS 실행!
		int count1=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!isvisited[i][j]) {
					BFS(new int[] {i, j}, board[i][j], false);
					count1++;
				}
			}
		}
		
		//방문기록 배열
		isvisited = new boolean[n][n];
		
		//적록색약O > 방문하지 않았다면 BFS 실행
		int count2=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!isvisited[i][j]) {
					BFS(new int[] {i, j}, board[i][j], true);
					count2++;
				}
			}
		}
		
		System.out.println(count1 +" "+ count2);
		
	}
	
	public static void BFS(int[] location, char color, boolean isredgreen) {		
		
		//큐 생성
		queue = new LinkedList();
		
		//큐에 삽입하고 방문처리
		queue.offer(location);
		isvisited[location[0]][location[1]]=true;
		
		while(!queue.isEmpty()) {
			
			//현재 좌표
			int[] curr = queue.poll();
		
			int i = curr[0];
			int j = curr[1];
			
			//사방 탐색
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				//조건1. 인덱스 범위 확인하기
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				
				//조건2. 색깔 확인하기 > 적록색약이라면 빨강과 초록이 같아야 한다
				if(isredgreen && (color=='R' || color=='G')) {
					if(board[dr][dc]=='B') continue;
				}
				
				if(isredgreen && color=='B') {
					if(board[dr][dc]=='R' || board[dr][dc]=='G') continue;
				}
				
				
				//조건2. 색깔 확인하기 > 적록색약이 아니라면, 다 구별해주기
				if(!isredgreen && board[dr][dc]!=color) continue;
				
				//조건3. 방문 확인하기
				if(isvisited[dr][dc]) continue;
				
				//조건을 만족하면 큐에 삽입하고 방문처리하기
				queue.offer(new int[] {dr, dc});
				isvisited[dr][dc]=true;			
			}
		}
		
	}
}
