import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a==0 && b==0 && c==0) break;
			
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			queue.offer(a);
			queue.offer(b);
			queue.offer(c);
			
			if(Math.pow(queue.poll(), 2) + Math.pow(queue.poll(), 2) == Math.pow(queue.poll(), 2)) 
				System.out.println("right");
			else System.out.println("wrong");
			
		};
	}
}
