import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int count, size;
	static int[] coordinate;
	static int[] x, y;
	static boolean[][] isvisited;
	static int[][] arr;
	static Queue<int[]> queue;
	static List<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		int n = sc.nextInt();	
		
		//배열 생성 및 값 입력받기
		arr= new int[n][n];	
		for(int i=0; i<arr.length; i++) {
			String str = sc.next();	//문자열로 입력받고
			for(int j=0; j<arr.length; j++) {	
				arr[i][j]=str.charAt(j)-'0';	//숫자로 변환하기
			}
		}
		
		isvisited = new boolean[n][n];	//방문체크 배열
		
		x = new int[] {0, 1, 0, -1};	//사방탐색 배열
		y = new int[] {1, 0, -1, 0};
		
		//x좌표와 y좌표를 담을 배열 > 클래스는 같은 패키지에 같은 이름을 2개 할 수 없어서 이름을 계속 새롭게 짓지 못하겠다...
		coordinate= new int[2];	
		
		count=0;	//단지의 개수 세는 변수
		list= new ArrayList();
		
		//만약 방문하지 않았고, 지도의 값이 0보다 크면 탐색 시작한다
		for(int i=0; i<arr.length; i++) {	
			for(int j=0; j<arr.length; j++) {
				if(!isvisited[i][j] && arr[i][j]>0) {
//					System.out.println("i : " +i+ ", j : " +j);
					BFS(new int[] {i, j}); 
					count++;			//단지 개수 세기
					list.add(size);		//하나의 단지에 아파트 개수 세기
				}
			}
		}
		
		//정렬 후 출력하기
		Collections.sort(list);
		System.out.println(count);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void BFS(int[] coordinate) {
		
		size=1;	//한 개의 단지 안에 있는 집의 수 
		
		//큐 생성
		queue = new LinkedList();
		
		//메서드에 들어오면 큐에 넣고, 방문 기록하기
		queue.offer(coordinate);
		isvisited[coordinate[0]][coordinate[1]]=true;
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int r=curr[0];
			int c=curr[1];
			
			for(int i=0; i<4; i++) {
				int dx = r+x[i];
				int dy = c+y[i];
				
				//조건 확인하기
				if(!(0<=dx && dx<arr.length && 0<=dy && dy<arr.length)) continue;
				if(isvisited[dx][dy]) continue;
				if(arr[dx][dy]==0) continue;
				
				//조건에 맞다면 큐에 넣고, 방문 기록하기
				queue.offer(new int[] {dx, dy});
				isvisited[dx][dy]=true;
				
				//집의 수를 세어보자
				size++;
			}
		}
	}
}
