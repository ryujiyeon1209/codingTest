import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//남 서 북 동 > 왼쪽으로 이동
		int dir = 0;
		int[] r = new int[] {1, 0, -1, 0};
		int[] c = new int[] {0, 1, 0, -1};
		
		//명령 개수와 명령어
		int count = sc.nextInt();
		char[] command = sc.next().toCharArray();
		
		//방향 탐색
		int x = 0;
		int y = 0;
		
		//최대 최소 좌표 값
		int maxx = 0;
		int maxy = 0;
		int minx = 0;
		int miny = 0;
		
		for(int i=0; i<command.length; i++) {
			if(command[i]=='F') {
				int dr = x+r[dir];
				int dc = y+c[dir];
				
				maxx = Math.max(maxx, dr);
				maxy = Math.max(maxy, dc);
				minx = Math.min(minx, dr);
				miny = Math.min(miny, dc);
				
				x=dr;
				y=dc;
			}
			else if(command[i]=='L') {
				dir=(dir+1)%4;
			}
			else if(command[i]=='R') {
				if(1<=dir) dir=dir-1;
				else dir=3-dir;
			}
		}
		
		//배열 총 크기 구하기
		int n = maxx-minx+1;
		int m = maxy-miny+1;
		
		//첫 좌표 저장
		char[][] map = new char[n][m];
		x = Math.abs(minx);
		y = Math.abs(miny);
		
		dir = 0;
		map[x][y]='.';
		
		//미로 만들기
		for(int i=0; i<command.length; i++) {
			if(command[i]=='F') {
				int dr = x+r[dir];
				int dc = y+c[dir];

				map[dr][dc]='.';
				
				x=dr;
				y=dc;
			}
			else if(command[i]=='L') {
				dir=(dir+1)%4;
			}
			else if(command[i]=='R') {
				if(1<=dir) dir=dir-1;
				else dir=3-dir;
			}
		}
		
		//벽 설치
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]!='.') map[i][j]='#';
			}
		}
		
		//출력
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
