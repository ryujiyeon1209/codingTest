import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, m, count;
	static char[][] map;
	static boolean[][] isvisited;
	static int[] r, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		//캠퍼스 배열 생성 및 값 입력받기
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			map[i]=sc.next().toCharArray();
		}
		
		//도연이가 있는 좌표 구하기
		int startR=0; int startC=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]=='I') {
					startR=i; 
					startC=j; 
					break;
				}
			}
		}
		
		//사방탐색 배열
		r = new int[] {-1, 0, 1, 0};
		c = new int[] {0, 1, 0, -1};
		
		//방문체크 배열
		isvisited= new boolean[n][m];
		
		count=0;
		BFS(new int[] {startR, startC});
		
		//출력
		if(count==0) System.out.println("TT");
		else System.out.println(count);	
	}
	
	
	public static void BFS(int[] location) {
		
		//큐 생성
		Queue<int[]> queue = new LinkedList();
		
		queue.add(location);
		isvisited[location[0]][location[1]]=true;
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int i = curr[0];
			int j = curr[1];
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				//맞지 않는 조건들
				if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
				if(map[dr][dc]=='X') continue;
				if(isvisited[dr][dc]) continue;
				
				//사람이면 count++
				if(map[dr][dc]=='P') count++;
				
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc});
			}
		}
	}
}
