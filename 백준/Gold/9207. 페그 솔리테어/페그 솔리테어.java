import java.util.*;

public class Main {
	
	static int h=5, w=9;
	static int remain, answer;
	static int[] r, c;
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=0; t<test; t++) {
			map = new char[h][w];
			for(int i=0; i<h; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			//pin이 최대 몇개인지 개수 세기
			int pin = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]=='o') pin++;
				}
			}
			
			remain = pin;
			answer = 0;
			
			r = new int[] {1, 0, -1, 0};
			c = new int[] {0, -1, 0, 1};
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]=='o') DFS(i, j, pin, 0);
				}
			}
			
			//출력
			System.out.println(remain + " " + answer);
		}
	}
	
	//DFS
	public static void DFS(int x, int y, int pin, int count) {
		
		if(pin<remain) {
			remain=pin;
			answer=count;
		}
		
		for(int k=0; k<4; k++) {
			
			//인접한 칸의 바늘이 있는지 확인
			int dr = x+r[k];
			int dc = y+c[k];
			
			if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
			if(map[dr][dc]!='o') continue;
			
			//그 다음 칸이 비어있는지 확인
			int ddr = dr+r[k];
			int ddc = dc+c[k];
			
			if(!(0<=ddr && ddr<h && 0<=ddc && ddc<w)) continue;
			if(map[ddr][ddc]!='.') continue;
			
			map[x][y]='.';
			map[dr][dc]='.';
			map[ddr][ddc]='o';
			
			//다음 바늘 찾으러 DFS
			for(int i=0; i<5; i++) {
				for(int j=0; j<9; j++) {
					if(map[i][j]=='o') DFS(i,j,pin-1,count+1);
				}
			}
			
			//원상복구
			map[x][y]='o';
			map[dr][dc]='o';
			map[ddr][ddc]='.';
			
		}
	}
}
