import java.util.*;

public class Main {
	
	static int r, c, count, max, result;
	static int[] coordinate;	//BFS의 큐에 넣을 좌표 배열
	static int[] x, y;
	static int[][] arr;
	static boolean[][] isvisited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();

		arr = new int[r][c];	//도화지 생성 및 값 입력받기
		for(int i=0; i<arr.length; i++) {	
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		x = new int[] {0, 1, 0, -1};	//사방탐색, 우 하 좌 상 순서
		y = new int[] {1, 0, -1, 0};
		
		isvisited = new boolean[r][c];	//방문 처리 배열
		result=0;	//그림 중 가장 큰 그림의 크기
		
		

		//시작 좌표 찾기
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]>0 && !isvisited[i][j]) {	//그림이 그려져 있고, 탐색하지 않았던 그림이라면
					coordinate = new int[] {i, j};		//BFS의 큐에 넣을 좌표 배열
//					System.out.println(i + " " +j+ " > " +isvisited[i][j]);
					count++;							//BFS가 호출되는 횟수가 그림의 개수다.	
					BFS(coordinate); 

					result = Math.max(max, result);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(result);
		
	}
	
	//BFS만들기
	public static void BFS(int[] coordinate2) {
		
		max=0;	//BFS가 호출될 때마다 하나의 그림의 크기를 구하므로 여기서 초기화!
		
		//큐 생성
		queue = new LinkedList();
		
		
		//BFS에 들어오면 큐에 넣고, 방문처리 해주기
		queue.add(coordinate2);
		isvisited[coordinate2[0]][coordinate2[1]]= true;

		
		while(!queue.isEmpty()) {
			
			//큐에서 가장 앞에 있는 값이 현재 내가 탐색할 좌표다.
			int[] coor = queue.poll();
			max++;

			int i = coor[0];
			int j = coor[1];
			
			//사방탐색 해주기
			for(int k=0; k<4; k++) {
				int dr = i+x[k];
				int dc = j+y[k];
				
				//조건 확인해주기
				if(!(0<=dr && dr<arr.length && 0<=dc && dc < arr[0].length)) continue;
				if(isvisited[dr][dc]) continue;
				if(arr[dr][dc]==0) continue;
				
				//조건에 맞다면, 큐에 삽입하고 방문처리 해주기
				isvisited[dr][dc]=true;
				queue.add(new int[] {dr, dc});
			}
			
		}
		
	}
}
