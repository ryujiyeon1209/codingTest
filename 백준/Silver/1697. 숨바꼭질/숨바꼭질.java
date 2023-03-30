import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, m, level, result;
	static int[] arr; 
	static boolean[] isvisited;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//수빈이 위치
		m = sc.nextInt();	//동생 위치
		
		arr = new int[] {-1, 1, 2};	//수빈이가 움직일 수 있는 위치 좌표
		isvisited = new boolean[100001];//방문체크배열 > 수빈이가 갈 수 있는 최대 거리가 100000이다  
	
		level=0;	//원래 제일 위에 있는 트리는 level이 1이지만, 현재 수빈이가 있는 위치에서의 시간은 0초이므로 0으로 초기화 한다.
		result=0;
		
		BFS(n);
		System.out.println(result);
	}
	
	public static void BFS(int location) {
		
		//BFS값을 넣고 뺄 큐 생성 및 최초 값 넣기
		queue = new LinkedList();
		queue.add(location);
		isvisited[location]=true;
		
		Outer:
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			//레벨 계산을 위한 반복문 > 현재 큐에 있는 모든 값들이 3번의 경우의 수를 모두 해야 레벨이 하나 증가한다
			for(int i=0; i<size; i++) {	
				
				int curr = queue.poll();
//				System.out.println("level : " +level+ ", curr : " +curr);
				if(curr==m) { result=level; break Outer;} 	//poll한 값이 동생 위치라면, 그 때의 level을 반환

				for(int k=0; k<3; k++) {	//현재 poll한 값을 기준으로 +1 -1 +5한 위치가 경우의 수가 된다.
					
					int dx=0;
					if(k==2) { dx = curr*arr[k]; } //수빈이가 2*으로 움직일 때
					else { dx = curr+arr[k]; }		//그 외에 수빈이가 1초에 움직여서 갈 수 있는 좌표
					
					//조건에 맞는지 확인 > 범위를 벗어나거나, 방문했던 곳이면 넘어가기 
					if(!(0<=dx && dx<100001)) continue;
					if(isvisited[dx]) continue;
					
					
					queue.add(dx);
					isvisited[dx]=true;
				}				
			}
			
//			한 사이클이 끝나면 level을 +1 해준다.
			level++;
		}
	}
}
