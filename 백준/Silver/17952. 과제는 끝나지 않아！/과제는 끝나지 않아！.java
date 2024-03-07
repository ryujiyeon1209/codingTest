import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//과제 개수 입력받기
		int n = sc.nextInt();
	
		//총 점수
		int answer = 0;
		
		Stack<int[]> stack = new Stack();
		while(0<n) {
			int isTest = sc.nextInt();
			
			//현재 주어진 과제가 있다면,
			if(isTest==1) {
				int point = sc.nextInt();
				int time = sc.nextInt();
				
				if(time-1==0) answer+=point;
				else stack.add(new int[] {isTest, point, time-1});
			} 
			
			//현재 주어진 과제가 없고, 해결하지 못한 과제가 있다면
			else if(isTest==0 && !stack.isEmpty()) {
				int[] node = stack.pop();
				
				int point = node[1];
				int time = node[2];
				
				if(time-1==0) answer+=point;
				else stack.add(new int[] {isTest, point, time-1});
			}
			
			n--;
		}
		
		//출력
		System.out.println(answer);
		
	}
}



