import java.util.*;

public class Main {
	
	static int h, w, test;
	static int[][] map;
	static int[] r, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		test = sc.nextInt();
		
		
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
			}
		}	
		
		//사방 탐색
		r = new int[] {1, 0, -1, 0};
		c = new int[] {0, -1, 0, 1};
		
		//공기청정기 찾기
		List<int[]> list = new ArrayList();
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]==-1) list.add(new int[] {i, j}); 
			}
		}	
		
		
		for(int t=0; t<test; t++) {
			//미세먼지 확산시키기
			BFS();
			
			//공기청정기 돌리기
			clean(list);
		}
		
		//미세먼지 양 구하기
		int answer = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]==-1) continue; 
				else answer+=map[i][j];
			}
		}	
		
		//출력
		System.out.println(answer);
	}
	
	//미세먼지 확산하기
	public static void BFS() {
		Queue<int[]> queue = new LinkedList();
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(0<map[i][j]) queue.add(new int[] {i, j, map[i][j]});
			}
		}	
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i = cur[0];
			int j = cur[1];
			int amount = cur[2];
					
			int count = 0;
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
				if(map[dr][dc]==-1) continue;
				
				count++;
				map[dr][dc]+=(int)Math.ceil(amount/5);
			}
			
			map[i][j]-=((int)Math.ceil(amount/5)*count);			
		}
	}
	
	//공기 청정기 돌리기
	public static void clean(List<int[]> list) {
		
		//반시계 방향
		int ux = list.get(0)[0];
		int uy = list.get(0)[1];
		
		Queue<Integer> queue = new LinkedList();
		queue.add(0);
		for(int i=uy+1; i<w-1; i++) {
			queue.add(map[ux][i]);
			map[ux][i] = queue.poll();
		}
		for(int i=ux; 0<i; i--) {
			queue.add(map[i][w-1]);
			map[i][w-1] = queue.poll();
		}
		for(int i=w-1; 0<i; i--) {
			queue.add(map[0][i]);
			map[0][i] = queue.poll();
		}
		for(int i=0; i<ux; i++) {
			queue.add(map[i][0]);
			map[i][0] = queue.poll();
		}
		for(int i=0; i<uy; i++) {
			queue.add(map[ux][i]);
			map[ux][i] = queue.poll();
		}
		
		//시계방향
		ux = list.get(1)[0];
		uy = list.get(1)[1];
		queue = new LinkedList();
		queue.add(0);
		for(int i=uy+1; i<w-1; i++) {
			queue.add(map[ux][i]);
			map[ux][i] = queue.poll();
		}
		for(int i=ux; i<h-1; i++) {
			queue.add(map[i][w-1]);
			map[i][w-1] = queue.poll();
		}
		for(int i=w-1; 0<i; i--) {
			queue.add(map[h-1][i]);
			map[h-1][i] = queue.poll();
		}
		
		for(int i=h-1; ux<i; i--) {
			queue.add(map[i][0]);
			map[i][0] = queue.poll();
		}
		for(int i=0; i<uy; i++) {
			queue.add(map[ux][i]);
			map[ux][i] = queue.poll();
		}
	}
}
