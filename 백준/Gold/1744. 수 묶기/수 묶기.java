import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> plusque = new PriorityQueue(Collections.reverseOrder());
		PriorityQueue<Integer> minusque = new PriorityQueue();
		int one=0;
		int zero=0;
		int result=0;
		
		
		int num = sc.nextInt();

		for(int i=0; i<num; i++) {			
			int n =sc.nextInt();
			if(n>1) {plusque.add(n);}
			if(n<0) {minusque.add(n);}
			if(n==0) zero++;
			if(n==1) one++;
		}
		
		while(plusque.size()>1) {
			int idx1 = plusque.poll();
			int idx2 = plusque.poll();
			
			result+= (idx1*idx2);
		}
		
		if(plusque.isEmpty()==false) {
			result+=plusque.poll();
		}
		
		while(minusque.size()>1) {
			int idx1 = minusque.poll();
			int idx2 = minusque.poll();
			
			result+= (idx1*idx2);
		}
		
		if(minusque.isEmpty()==false) {
			if(zero==0) {
				result+= minusque.poll();
			}
		}
		
		result+=one;
		
		System.out.println(result);

	}
}
