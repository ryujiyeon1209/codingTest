import java.util.*;

public class Main {
	
	static char[][] map;
	static boolean[] isvisited;
	static int[] r, c;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		//사방향 탐색, 방문 체크 배열
		r = new int[] {-1, 0, 1, 0};
		c = new int[] {0, 1, 0, -1};
		
		isvisited = new boolean[26];
		isvisited[map[0][0]-'A'] = true;
		
		max = 0;
		DFS(0, 0, 1);
		
		//출력
		System.out.println(max);
	}
	
	//DFS
	public static void DFS(int i, int j, int depth) {
		
		if(max < depth) max = depth;
		
		//사방 탐색
		for(int k=0; k<4; k++) {
			int dr = i+r[k];
			int dc = j+c[k];
			
			//범위에 벗어나거나, 이미 사용한 알파벳일 경우 넘어가기
			if(!(0<=dr && dr<map.length && 0<=dc && dc<map[i].length)) continue;
			if(isvisited[map[dr][dc]-'A']) continue;
			
			//방문 체크 후 다음 단계
			isvisited[map[dr][dc]-'A'] = true;
			DFS(dr, dc, depth+1);
			
			//원상복구
			isvisited[map[dr][dc]-'A'] = false;
			
		}
	}
}

