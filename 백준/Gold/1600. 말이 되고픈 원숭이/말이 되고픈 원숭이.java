import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int K; //말처럼 움직일 수 있는 수
	static int W,H; //맵 크기
	static int[][] map;
	static boolean[][][] visited; //방문여부 + 점프 체크
	static int ans = Integer.MAX_VALUE;
	
	static int[] dr = {0,-1,0,1,-1,1,2,2,-1,1,-2,-2}; //좌,상,우,하
	static int[] dc = {-1,0,1,0,-2,-2,-1,1,2,2,1,-1}; //대각선까지
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++) { //맵 받아주기
			for(int j=0; j<W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		bfs();
		
		if(ans == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0,0,0,0));
		visited[0][0][0] = true;
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
		
			//도착했으면 끝!
			if(p.x == H-1 && p.y == W-1) {
				ans = p.cnt;
				break;
			}
			
			for(int i=0; i<12; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];
				
				//칸 넘어가면 pass
				if(nr<0 || nc<0 || nr>=H || nc>=W)
					continue;
				//방문할 수 없다면 pass
				if(map[nr][nc] == 1)
					continue;
				//말처럼 움직이는데 점프 횟수가 남아있지 않다면 pass.
				if(i>=4 && p.jump >= K)
					continue;
				//한 칸씩 이동으로 방문 한 적 있으면 pass
				if(i<4 && visited[nr][nc][p.jump])
					continue;
				//말 처럼 뛰었을 때 방문 한 적 있으면 pass
				if(i>=4 && visited[nr][nc][p.jump+1])
					continue;
				
				//점프 안 하고 갈 수 있는 길은 가보기
				if(i<4){
					visited[nr][nc][p.jump] = true;
					q.add(new Point(nr,nc, p.cnt+1, p.jump));
				}
				//점프 할 수 있으면 점프 해보기.
				if(i>=4 && p.jump < K){					
					visited[nr][nc][p.jump+1] = true;
					q.add(new Point(nr,nc, p.cnt+1, p.jump+1));
				}
			}
		}
	}
	
	static class Point{
		int x,y, cnt, jump;
		Point(int x, int y, int cnt, int jump){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.jump = jump;
		}
	}

}