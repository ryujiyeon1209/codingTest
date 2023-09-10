import java.util.*;

public class Main {
	
	static int n;
	static int[] r, c;
	static int[][] arr;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 값 입력받기
		n = sc.nextInt();
		arr = new int[n][n];
		
		int m = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j]=sc.nextInt();
				if(m<arr[i][j]) m = arr[i][j];
			}
		}
		
		//사방 탐색
		r = new int[] {-1, 0, 1, 0};
		c = new int[] {0, 1, 0, -1};
		
		//테스트케이스 시작
		int max=0;
		for(int t=0; t<=m; t++) {
			
			int count=0;
			isvisited = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {	
					
					//장마보다 값이 크고, 방문하지 않았던 곳 DFS 시작
					if(t<arr[i][j] && !isvisited[i][j]) {
						count++;
						DFS(new int[] {i, j}, t);
					}
					
				}
			}
			
			max = Math.max(max, count);
		}
		
		//출력
		System.out.println(max);
	}
	
	
	public static void DFS(int[] location, int t) {
		
		Queue<int[]> queue = new LinkedList();
		
		queue.add(location);
		isvisited[location[0]][location[1]] = true;
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int i=curr[0];
			int j=curr[1];
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				if(arr[dr][dc]<=t) continue;
				if(isvisited[dr][dc]) continue;
				
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc});
			}
		}
	} 
}
