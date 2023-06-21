import java.util.*;

public class Main {
	
	static int n, m, count;
	static int[] r, c;
	static int[][] arr;
	static boolean[][] isvisited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		n = sc.nextInt();
		m = sc.nextInt();
		
		//시작 좌표와 방향 입력받기
		int startR = sc.nextInt();
		int startC = sc.nextInt();
		int direction = sc.nextInt();
		
		//2차원 배열 생성 및 값 입력받기
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		//방문 체크 배열
		isvisited = new boolean[n][m];
		
		//사방탐색(북, 동, 남, 서)
		r = new int[] {-1, 0, 1, 0};
		c = new int[] {0, 1, 0, -1};
		
		count=0;
		BFS(new int[] {startR, startC, direction});
		
        //출력
		System.out.println(count);
	}
	
	
	public static void BFS(int[] location) {
		queue = new LinkedList();
		
		queue.add(location);
		isvisited[location[0]][location[1]]=true;
		
		while(!queue.isEmpty()) {
			
			//현재 좌표 꺼내기
			int[] curr = queue.poll();
			
			int i = curr[0];
			int j = curr[1];
			int direction = curr[2];
			
			
			if(arr[i][j]==0) { count++; arr[i][j]=2;}	//청소하는 칸의 개수
			
			int tmp=0;	//사방의 청소되어 있거나, 벽인 경우
			
			//사방탐색 시작
			for(int k=0; k<4; k++) {
				
				direction= (direction+3)%4;	//왼쪽방향으로 변환
				
				int dr = i+r[direction];
				int dc = j+c[direction];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<m)) { continue; }
				if(arr[dr][dc]==1 || arr[dr][dc]==2) { tmp++; continue; }	//주변이 벽이거나 이미 청소한 방일 때
				if(arr[dr][dc]==0) { queue.add(new int[] {dr, dc, direction}); break;}	//주변이 청소 안한 방일 때
			}

			
			//주변 모두가 벽이나 청소가 된 방으로 이루어져 있을 때
			if(tmp>=4) {
				int back = (direction+2)%4;
				int dr = i+r[back];
				int dc = j+c[back];
				
				if((0<=dr && dr<n && 0<=dc && dc<m) && arr[dr][dc]!=1) queue.add(new int[] {dr, dc, direction});
			}
			
		}
	}

	
}
