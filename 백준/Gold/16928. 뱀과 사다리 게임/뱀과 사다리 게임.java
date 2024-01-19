import java.util.*;

public class Main {
	
	static int answer;
	static int[] arr, ladder, snake;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ladder = new int[101];
		for(int i=0; i<n; i++) {
			ladder[sc.nextInt()] = sc.nextInt();
		}
		
		snake = new int[101];
		for(int i=0; i<m; i++) {
			snake[sc.nextInt()] = sc.nextInt();
		}
		
		answer = Integer.MAX_VALUE;
		arr = new int[101];
		BFS();
		
		//출력
		System.out.println(answer);
	}
	
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList();
		
		arr[1]=0;
		queue.add(new int[] {1, 0});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int num = curr[0];
			int depth = curr[1];
			
			if(num==100) {
				answer = depth;
				return;
			}
			
			for(int k=1; k<=6; k++) {
				int key = num+k;
				
				if(!(1<=key && key<=100)) continue;
				if(0<arr[key]) continue;
				
				//1. 뱀이 나왔다면  건너 뛴다
				if(snake[key]!=0) {
					arr[snake[key]] = depth+1;
					queue.add(new int[] {snake[key], depth+1});
				}
				
				//2. 사다리가 존재한다면, 현재 번호와 사다리로 이동한 번호 모두 depth+1로 이동 가능하다
				if(ladder[key]!=0) {
					arr[key] = depth+1;
					arr[ladder[key]] = depth+1;

					queue.add(new int[] {ladder[key], depth+1});
				}
					
				//사다리 또는 뱀이 아니라면
				if(snake[key]==0 && ladder[key]==0 ) {
					arr[key] = depth+1;
					queue.add(new int[] {key, arr[key]});
				}
			}

		}
	}
}
