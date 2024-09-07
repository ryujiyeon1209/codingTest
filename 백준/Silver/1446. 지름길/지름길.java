import java.util.*;

public class Main {
	
	static int n, arrival, distance, answer;
	static int[][] map;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arrival = sc.nextInt();
		
		map = new int[n][3];
		for(int i=0; i<n; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();
		}
		
		isvisited = new boolean[n];
		
		distance = 0;
		answer = Integer.MAX_VALUE;
		DFS(0);
	
		//출력
		System.out.println(answer);
	}
	
	//DFS
	public static void DFS(int cur) {
		
		
		
		if(cur==arrival) {
			answer = Math.min(answer, distance);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(isvisited[i]) continue;		//이미 방문한 지름길이라면
			if(map[i][0]<cur) continue;		//현재 위치보다 늦은 출발 위치라면
			if(arrival<map[i][1]) continue;	//도착 위치보다 먼 도착 위치라면

			
			//현재 위치가 지름길 시작보다 늦다면
			if(cur<map[i][0]) {
				distance+=(map[i][0]-cur);
				DFS(map[i][0]);
				
				distance-=(map[i][0]-cur);
			}
			
			//현재 위치가 지름길 시작 위치라면
			else if(cur==map[i][0]) {
				
				distance+=map[i][2];
				isvisited[i]=true;
				DFS(map[i][1]);
				
				distance-=map[i][2];
				isvisited[i]=false;
			}
		}
		

		//도착 지점까지 그냥 가기
		distance+=(arrival-cur);
		DFS(arrival);
		
		distance-=(arrival-cur);
		
		
	}
}
