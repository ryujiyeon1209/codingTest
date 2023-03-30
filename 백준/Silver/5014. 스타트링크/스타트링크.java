import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int floor, start, goal, up, down, level;
	static int[] arr;
	static boolean flag;
	static boolean[] isvisited;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		floor= sc.nextInt();	//건물의 총 높이
		start= sc.nextInt();	//강호의 현재 층 수
		goal= sc.nextInt();		//강호가 가야 하는 목표 층
		up= sc.nextInt();		//한번에 위로 올라가는 층수
		down= sc.nextInt();		//한번에 아래로 내려가도 층수
		
		arr = new int[]{up, -down};
		isvisited = new boolean[floor+1];	//방문 체크 배열
		
		BFS(start);
		if(flag) System.out.println(level);
		else System.out.println("use the stairs");
	}
	
	public static void BFS(int start) {
		
		//큐 생성
		queue = new LinkedList();
		
		//최초 값을 큐에 삽입, 방문처리
		queue.add(start);
		isvisited[start]=true;
		
		Outer:
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			//BFS레벨을 찾을 때, 큐의 사이즈만큼 반복한 한 번의 텀이 레벨 하나다. 
			for(int i=0; i<size; i++) {	
				
				int curr = queue.poll();
				if(curr==goal) { flag = true; break Outer; }
				
				for(int k=0; k<arr.length; k++) {
				
					int dx = curr+arr[k];
					
					//조건 확인하기
					if(!(1<=dx && dx<=floor)) continue;
					if(isvisited[dx]) continue;
					
					//조건에 맞다면, 큐에 넣어주고 방문처리하기
					queue.add(dx);
					isvisited[dx]=true;
					
				}
			}
			
			//큐의 사이즈만큼 반복문이 끝나면 트리의 레벨 하나의 탐색이 끝난 것!
			level++;
		}		
	}
}
