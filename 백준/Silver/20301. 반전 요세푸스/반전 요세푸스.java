import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//총 인원수
		int k = sc.nextInt();	//제거 기준 번호
		int m = sc.nextInt();	//방향 기준 번호
		
		Deque<Integer> queue = new LinkedList();
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		
		int count = 0;
		int dir = 0;
		boolean change = true;
		
		StringBuilder sb = new StringBuilder();
		while(0<queue.size()) {
			
			int num = 0;
			
			if(change) num = queue.poll();
			else num = queue.pollLast();
			count++;
			
			if(count%k!=0 && change) {			//제거하지 않고 왼>오 방향
				queue.add(num);
			}
			else if(count%k!=0 && !change) {	//제거하지 않고 오>왼 방향
				queue.addFirst(num);
			}
			else {								//제거할 때
				sb.append(num+ "\n");
				
				dir++;
				if(dir%m==0) change=!change;
			}
		}
		
		//출력
		System.out.println(sb.toString());
	}
}
