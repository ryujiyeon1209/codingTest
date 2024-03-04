import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//장부 돈 저장하기
		Stack<Long> stack = new Stack();
		for(int i=0; i<n; i++) {
			long num = sc.nextInt();
			
			if(num==0) stack.pop();
			else stack.add(num);
		}
		
		//최종적으로 적어낸 수의 합
		long answer = 0;
		while(!stack.isEmpty()) {
			answer+=stack.pop();
		}
		
		//출력
		System.out.println(answer);
	}
}
