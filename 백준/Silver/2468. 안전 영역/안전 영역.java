import java.util.*;
import java.util.Scanner;

public class Main {
	static int n, count, max, maxRain;
	static int[] r, c;
	static int[][] arr;
	static boolean[][] isvisited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//배열 크기
		maxRain=0;			//최대로 많이 내리는 비의 양
		
		arr = new int[n][n];	//배열 생성 및 값 입력받기
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		r = new int[] {0, 1, 0 ,-1};
		c = new int[] {1, 0, -1, 0};
		
		//비의 양이 1~최대까지, 비의 양에 따라 달라지는 안전 영역을 구하자
		max=0;
		
		//비의 양이 1씩 오를 때마다 배열의 크기와 비의 크기가 같다면, 그 지역은 물에 잠겨서 0이 된다
		Outer:
		for(int rain=0; rain<=100; rain++) {
			
			for(int i=0; i<arr.length; i++) {	
				for(int j=0; j<arr.length; j++) {
					if(arr[i][j]== rain) {
						arr[i][j]=0;
					}
				}
			}

			//방문 배열 초기화
			isvisited = new boolean[n][n];
			
			//지역을 탐색하며 안전지역이 몇개인지 확인해보자
			count=0;
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(arr[i][j]>0 && !isvisited[i][j]) {
						BFS(new int[] {i, j}); count++;
					}
				}
			}
			
			if(max<=count) max = count;
		}
		
		//출력
		System.out.println(max);
		
	}
	
	public static void BFS(int[] location) {
		
		//큐 생성 및 값 넣기
		queue = new LinkedList();
		queue.offer(location);
		
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();	//현재 지역의 높이
			
			int i= curr[0];
			int j= curr[1];
			
			for(int k=0; k<4; k++) {	//사방 탐색
				int dr = i+r[k]; 
				int dc = j+c[k];
				
				//조건에 맞는지 확인
				if(!(0<=dr && dr<arr.length && 0<=dc && dc<arr.length)) { continue; }
				if(isvisited[dr][dc]) continue;
				if(arr[dr][dc]==0) continue;
				
				//조건에 맞다면 큐에 넣고 방문처리하기
				queue.offer(new int[] {dr, dc});
				isvisited[dr][dc]=true;
			}
		}
		
	}
}
