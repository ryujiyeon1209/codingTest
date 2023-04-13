import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int r, c, cabbage, count;
	static int[] coordinate, x, y;
	static int[][] arr;
	static boolean[][] isvisited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			c = sc.nextInt();		//가로
			r = sc.nextInt();		//세로
			cabbage = sc.nextInt();	//배추 개수
			
			arr= new int[r][c];	//배열 생성 및 배추를 심을 좌표 받기
			for(int i=0; i<cabbage; i++) {
				int tmpj=sc.nextInt();
				int tmpi=sc.nextInt();
				
				arr[tmpi][tmpj]=1;
			}
			
			isvisited = new boolean[r][c];	//방문 처리 배열
			x = new int[] {0, 1, 0, -1};
			y = new int[] {1, 0, -1, 0};
			
			
			count =0;	//필요한 배추흰지렁이 개수
			
			//배추가 심어져 있고, 내가 탐색하지 않은 곳이라면 BFS메서드 호출
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[0].length; j++) {
					if(arr[i][j]>0 && !isvisited[i][j]) {	
						BFS(new int[] {i, j});
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	public static void BFS(int[] coordinate) {
		
		queue = new LinkedList();
		
		//좌표가 들어오면 큐에 삽입하고 방문처리를 한다
		queue.add(coordinate);
		isvisited[coordinate[0]][coordinate[1]]=true;
		
		//큐가 공백상태가 될 때까지 반복
		while(!queue.isEmpty()) {
			
			int[] coor = queue.poll();
			int i = coor[0];
			int j = coor[1];
			
			//사방 탐색 시작
			for(int k=0; k<4; k++) {
				int dr = i +x[k];
				int dc = j +y[k];
				
				//조건에 맞는지 확인 > 인덱스, 방문, 배추가 있는지 등
				if(!(0<=dr && dr<arr.length && 0<=dc && dc<arr[0].length)) continue;
				if(isvisited[dr][dc]) continue;
				if(arr[dr][dc]==0) continue;
				
				//조건에 맞다면 큐에 삽입하고 방문처리
				queue.add(new int[] {dr, dc});
				isvisited[dr][dc]=true;
			}
		}
	} 
}
