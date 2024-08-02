import java.util.*;

public class Main {
	
	static int n, min;
	static int[] select, r, c;
	static int[][] map;
	static List<int[]> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		list = new ArrayList();
		for(int i=1; i<n-1; i++) {
			for(int j=1; j<n-1; j++) {
				list.add(new int[] {i, j});
			}
		}
		
		select = new int[3];
		
		r = new int[] {-1, 1, 0, 0};
		c = new int[] {0, 0, -1, 1};
		
		min = Integer.MAX_VALUE;
		combination(0, 0);
		
		System.out.println(min);
	}
	
	//조합 : 화단에 꽃 심을 3자리 구하기
	public static void combination(int idx, int value) {
		if(select.length<=idx) {

			int sum = 0;
			boolean flag = true;
			boolean[][] isvisited = new boolean[n][n];

			for(int t=0; t<select.length; t++) {
				int[] cur = list.get(select[t]);
				
				int i = cur[0];
				int j = cur[1];
				
				sum+=map[i][j];
				isvisited[i][j]=true;
				
				for(int k=0; k<4; k++) {
					int dr = i+r[k];
					int dc = j+c[k];
					
					if(!(0<=dr && dr<n && 0<=dc && dc<n)) {
						flag = false;
						break;
					}
					if(isvisited[dr][dc]) {
						flag =false;
						break;
					}
					
					sum+=map[dr][dc];
					isvisited[dr][dc]=true;
				}
				
				if(!flag) break;
			}
			
			if(flag) {
				min = Math.min(min, sum);
			}
			return;
		}
		
		if(list.size()<=value) return;
		
		
		select[idx]=value;
		combination(idx+1, value+1);
		
		combination(idx, value+1);
	}
}
