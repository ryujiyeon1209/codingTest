import java.util.*;

public class Main {
	
	static char[][] map;
	static int[] point;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//2차원 배열
		map = new char[4][8];
		for(int i=0; i<map.length; i++) {
			map[i] = sc.next().toCharArray();
		}

		//12시 방향 인덱스 저장 배열
		point = new int[4];
		
		//DFS
		int test = sc.nextInt();
		for(int t=0; t<test; t++) {
			int num = sc.nextInt();
			int dir = sc.nextInt();
			
			isvisited = new boolean[4];
			DFS(num-1, dir);
		}
		
		//점수 구하기
		int answer = 0;
		for(int i=0; i<4; i++) {
			if(map[i][point[i]]=='1') {
				if(i==0) answer+=1;
				else if(i==1) answer+=2;
				else if(i==2) answer+=4;
				else if(i==3) answer+=8;
			}
		}
		
		//출력
		System.out.println(answer);
	}
	
	//DFS
	public static void DFS(int num, int dir) {

		isvisited[num] = true;
		
		//확인 > 다른 극이면 인접한 톱니바뀌 회전
		int pre = num-1;
		int next = num+1;
		
		//현재 톱니바퀴 번호 3번, 인접 톱니바퀴 번호 7번
		if(next<4 && !isvisited[next]) {
			int idx = (point[num]+2)%8;
			int nidx = (point[next]+6)%8;
			
			if(map[num][idx]!=map[next][nidx]) DFS(next, dir*-1);
		}
		
		//현재 톱니바퀴 번호 7번, 인접 톱니바퀴 번호 3번
		if(0<=pre && !isvisited[pre]) {
			int idx = (point[num]+6)%8;
			int pidx = (point[pre]+2)%8;
			
			if(map[num][idx]!=map[pre][pidx]) DFS(pre, dir*-1);
		}
		
		//회전
		if(dir==1) {			//시계 방향
			point[num]=(point[num]-1+8)%8;
		}
		
		else if(dir==-1) {		//반시계 방향
			point[num]=(point[num]+1)%8;
		}
	}
}
