import java.util.*;

public class Main {
	
	static int n, m;
	static int[] r, c;
	static char[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		
		int q = sc.nextInt();
		for(int i=0; i<q; i++) {
			map[sc.nextInt()-1][sc.nextInt()-1]='Q';
		}
		
		int k = sc.nextInt();
		for(int i=0; i<k; i++) {
			map[sc.nextInt()-1][sc.nextInt()-1]='K';
		}
		
		int p = sc.nextInt();
		for(int i=0; i<p; i++) {
			map[sc.nextInt()-1][sc.nextInt()-1]='P';
		}
		
		isvisited = new boolean[n][m];
		
		r = new int[] {-1, 1, 0, 0, -1, -1, 1, 1, -2, -1, -2, -1, 2, 1, 2, 1};
		c = new int[] {0, 0, -1, 1, -1, 1, -1, 1, -1, -2, 1, 2, -1, -2, 1, 2};
		
		qchange();
		kchange();
		pchange();
		
		int answer = 0;
		for(int i=0; i<isvisited.length; i++) {
			for(int j=0; j<isvisited[i].length; j++) {
				if(!isvisited[i][j]) answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	//Queen이 갈 수 있는 곳 표시
	public static void qchange() {
		
		List<int[]> list = new ArrayList<>();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]=='Q') list.add(new int[] {i, j});
			}
		}
		
		for(int t=0; t<list.size(); t++) {
			int i = list.get(t)[0];
			int j = list.get(t)[1];
			
			isvisited[i][j]=true;
			
			for(int k=0; k<8; k++) {
				int dr = i;
				int dc = j;
				
				while(true) {
					dr+=r[k];
					dc+=c[k];
					
					if(!(0<=dr && dr<n && 0<=dc && dc<m)) break;
					if(map[dr][dc]=='P') break;
					if(map[dr][dc]=='K') break;
					
					isvisited[dr][dc]=true;
				}
			}
		}
	}
	
	//Knight이 갈 수 있는 곳 표시
	public static void kchange() {
		
		List<int[]> list = new ArrayList<>();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]=='K') list.add(new int[] {i, j});
			}
		}
		
		for(int t=0; t<list.size(); t++) {
			int i = list.get(t)[0];
			int j = list.get(t)[1];
			
			isvisited[i][j]=true;
			
			for(int k=8; k<16; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
	
				if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
				isvisited[dr][dc]=true;
				
			}
		}
	}
	
	//Pawn이 갈 수 있는 곳 표시
	public static void pchange() {
		
		List<int[]> list = new ArrayList<>();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]=='P') isvisited[i][j]=true;
			}
		}
	}
}
