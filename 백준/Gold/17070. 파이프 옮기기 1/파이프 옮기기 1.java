import java.util.*;

public class Main {
	
	static int n,count;
	static int[][] map;
	static int[] startR, startC, endR, endC;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();				
			}
		}
		
		//방향
		startR = new int[] {0, 0, 1, 1, 1, 1, 1};
		startC = new int[] {1, 1, 0, 0, 1, 1, 1};
		endR = new int[] {0, 1, 1, 1, 0, 1, 1};
		endC = new int[] {1, 1, 0, 1, 1, 0, 1};
		
		count=0;
		BFS(new int[] {0, 0, 0, 1, 1});
		
        //출력
		System.out.println(count);
	}
	
	//BFS
	public static void BFS(int[] location) {
		//큐 생성
		Queue<int[]> queue = new LinkedList();
		
		//최초 좌표 큐에 넣기
		queue.add(location);
		
		//최종 좌표가 벽인 경우 
		if(map[n-1][n-1]==1) { count=0; return; } 
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int r1 = curr[0];
			int c1 = curr[1];
			int r2 = curr[2];
			int c2 = curr[3];
			int direction = curr[4];
			
			
			if((r1==n-1 && c1==n-1) || (r2==n-1 && c2==n-1)) count++;
			
			int start=0; int end =0;
			if(direction==1) { start =0; end=2; }		//현재 방향이 가로일 때
			else if(direction==2) { start=2; end=4;}	//현재 방향이 세로일 때
			else { start=4; end=7;}			            //현재 방향이 대각선일 때
				
			//탐색
			for(int k=start; k<end; k++) {
				int dr1 = r1+startR[k];
				int dc1 = c1+startC[k];
				int dr2 = r2+endR[k];
				int dc2 = c2+endC[k];
				
				if(!(0<=dr1 && dr1<n && 0<=dc1 && dc1<n 
                     && 0<=dr2 && dr2<n && 0<=dc2 && dc2<n)) continue;
				if(map[dr1][dc1]==1 || map[dr2][dc2]==1) continue;
				if((k==1 || k==3 || k==6) && 
						(map[dr2-1][dc2]==1 || map[dr2][dc2-1]==1)) continue; 
				
				//방향 정하기
				int newDirection=0;
				if(k==0 || k==4) newDirection=1;
				else if(k==2 || k==5) newDirection=2;
				else newDirection=3;
				
				//큐에 등록
				queue.add(new int[] {dr1, dc1, dr2, dc2, newDirection});
			}
		}
	}
}
