import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int gr, gc, depth;
	static int[] r, c, curr;
	static int[][] arr;
	static boolean[][] isvisited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		gr = sc.nextInt();	//목표 좌표 행
		gc = sc.nextInt();	//목표 좌표 열

		arr = new int[gr][gc];	//배열 생성 및 값 입력받기
		for(int i=0; i<gr; i++) {	
			String str = sc.next();
			for(int j=0; j<gc; j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		
		isvisited = new boolean[gr][gc];	//방문 체크 배열
		
		r = new int[] {0, 1, 0, -1};	//사방탐색 > 우 하 좌 상
		c = new int[] {1, 0, -1, 0};
		
		depth=0;	//미로를 벗어나기 위해 움직인 횟수
		
		BFS(new int[] {0,0, 1});
		System.out.println(curr[2]+1);
	}
	
	public static void BFS(int[] location) {
		
		//큐 생성
		queue = new LinkedList();
		
		//값 넣고 방문 처리하기
		queue.offer(location);
		isvisited[location[0]][location[1]]=true;
		
		Outer:
		while(!queue.isEmpty()) {
			
			curr = queue.poll();
			
			
			int i = curr[0];
			int j = curr[1];
			
			for(int k=0; k<4; k++) {	//사방 탐색
				int dr = i + r[k];
				int dc = j + c[k];
				
				//조건에 맞는지 확인하기
				if(!(0<=dr && dr<gr && 0<=dc && dc<gc)) { continue; }
				if(isvisited[dr][dc]) { continue; }
				if(arr[dr][dc]==0) { continue; }
				if(dr==gr-1 && dc==gc-1) break Outer;
				
				//조건에 맞다면 큐에 넣고 방문 체크
				queue.offer(new int[] {dr, dc, curr[2]+1});
				isvisited[dr][dc]= true;
			}
			
	
		}
	}
}
