import java.util.*;

public class Main {
	
	static int[][] map;
	static int time;
	static int r, c;
	static int[] dr, dc;
	static Queue<int[]> queue;
	static boolean done;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//지도 생성
		int n = sc.nextInt();
		map = new int[n][n];
		
		//사과  표시하기
		int apple = sc.nextInt();
		for(int i=0; i<apple; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			map[r-1][c-1] = 1;
		}
		
		//뱀이 이동하는 좌표와 시간
		r = 0;			
		c = 0;
		time = 1;
		
		//뱀의 이동 방향
		int nomal = 0;
		dr = new int[] {0, 1, 0, -1};
		dc = new int[] {1, 0, -1, 0};
		
		done = false;
		
		//뱀이 이동하기
		queue = new LinkedList();
		queue.add(new int[] {0, 0});
		
        //이동시점과 방향 입력받기
		int count = sc.nextInt();
		for(int i=0; i<count; i++) {
			int change = sc.nextInt();
			String dir = sc.next();
			
            //이동
			while(time<=change) {
				move(nomal);
				
				//벽에 부딪혔거나 뱀의 몸과 부딪혔다면 종료
				if(done) {
					System.out.println(time);
					return;
				}
			}
			
			//방향 바꾸기
			if(dir.equals("D")) nomal=(nomal+1)%4;
			else if(dir.equals("L")) nomal=(nomal-1+4)%4;
		}
		
		//그 방향으로 계속 전진하기
		while(!done) {
			move(nomal);
		}

		
		//종료
		System.out.println(time);
	}
	
	//이동하기
	public static void move(int nomal) {
		
		r+=dr[nomal];				
		c+=dc[nomal];
		
		//벽에 부딪히거나 뱀의 몸과 부딪힌다면
		if(!(0<=r && r<map.length && 0<=c && c<map.length))  { done = true; return; }
		else if(map[r][c]==-1)  { done = true; return; }
		
		//사과가 없다면 꼬리 없애기
		if(map[r][c]==0) {
			int[] tail = queue.poll();
			map[tail[0]][tail[1]] = 0;
		}
		
		map[r][c]=-1;
		queue.add(new int[] {r, c});
		
		time++;
		
	} 
}

