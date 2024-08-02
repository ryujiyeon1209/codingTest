import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];	
		boolean[][] isvisited = new boolean[n][m];
		
		//장애물 설치
		int tric = sc.nextInt();
		for(int i=0; i<tric; i++) {
			map[sc.nextInt()][sc.nextInt()] = -1;
		}
		
		//시작 위치
		int x = sc.nextInt();
		int y = sc.nextInt();
		isvisited[x][y]=true;
		
		//방향 : 상 하 좌 우
		int[] r = new int[] {-1, 1, 0, 0};
		int[] c = new int[] {0, 0, -1, 1};
		
		int[] dir = new int[4];
		for(int i=0; i<dir.length; i++) {
			dir[i] = sc.nextInt()-1;
		}
		
		int idx = 0;
		int[] count = new int[4];
		
		boolean flag = true;
		while(flag) {
			
			int dr = x;
			int dc = y;
			
			while(true) {
				
				//지정한 방향으로 일직선으로 움직인다
				dr = x+r[dir[idx]];
				dc = y+c[dir[idx]];
				
				//범위를 벗어나면 멈추기
				if(!(0<=dr && dr<n &&0<=dc && dc<m)) {
					count[dir[idx]]++;
					break;
				}
				
				//방문한 지역이면 멈추기
				if(isvisited[dr][dc]) {
					count[dir[idx]]++;
					break;
				}
				
				//장애물을 만나면 멈추기
				if(map[dr][dc]==-1) {
					count[dir[idx]]++;
					break;
				}
			
				x = dr;
				y = dc;
			
				count = new int[4];
				isvisited[dr][dc]=true;
			}
			
			flag = false;
			for(int i=0; i<count.length; i++) {
				if(count[i]==0) flag = true;
			}
			
			idx=(idx+1)%4;
		}
		
		//출력
		System.out.println(x+ " " +y);
		
	}
}
