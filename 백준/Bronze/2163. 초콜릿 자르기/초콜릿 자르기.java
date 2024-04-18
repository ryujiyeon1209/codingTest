import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        //정보 입력받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] {n, m});
		
		int count = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			if(x==1 && y==1) continue;
			
            //2로 나눌 수 있으면 나누기
			if(x!=1 && x%2==0) {
				queue.add(new int[] {x/2, y});
				queue.add(new int[] {x/2, y});
			}
			
            //한개씩 쪼개기
			else if(x!=1 && x%2!=0) {
				queue.add(new int[] {x-1, y});
				queue.add(new int[] {x-(x-1), y});
				
			}
			
            //2로 나눌 수 있으면 나누기
			else if(y!=1 && y%2==0) {
				queue.add(new int[] {x, y/2});
				queue.add(new int[] {x, y/2});
			}
			
            //한개씩 쪼개기
			else if(y!=1 && y%2!=0) {
				queue.add(new int[] {x, y-1});
				queue.add(new int[] {x, y-(y-1)});
				
			}
			
			count++;
		}
		
		//출력
		System.out.println(count);
		
	}
}
