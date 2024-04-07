import java.util.*;

public class Main {
	
	static int[][] map;
	static int[] r, c;
	static int[] sel;
	static List<String> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		//숫자판 정보 입력받기
		map = new int[5][5];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//사방향 탐색
		r = new int[] {-1, 0, 1, 0};
		c = new int[] {0, 1, 0, -1};
		
		//중복제거를 위한 list
		list = new ArrayList();
		
		//DFS 실행
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				sel = new int[6];
				
				sel[0] = map[i][j];
				DFS(i, j, 1);
			}
		}
	
		//출력
		System.out.println(list.size());
	}
	
	
	//DFS
	public static void DFS(int i, int j, int depth) {
		
		//6자리 수가 다 채워지면
		if(6<=depth) {
			String str = "";
			for(int k=0; k<sel.length; k++) {
				str+=sel[k];
			}
			
			if(!list.contains(str)) list.add(str);
			return;
		}
		
		//사방향 탐색
		for(int k=0; k<4; k++) {
			int dr = i+r[k];
			int dc = j+c[k];
			
			if(!(0<=dr && dr<map.length && 0<=dc && dc<map.length)) continue;
			
			sel[depth] = map[dr][dc];	//새로운 숫자 더하기
			DFS(dr, dc, depth+1);
			
			sel[depth] = 0;				//원상 복구
		}
	}
}
