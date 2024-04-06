import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//수열 배열
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//정답 배열
		int[] answer = new int[n];
		Arrays.fill(answer, -1);
		
		//큰 수 찾기
		Stack<Integer> stack = new Stack();
		for(int i=0; i<arr.length; i++) {
			
			//stack에 들어있는 인덱스의 값보다 현재 값이 크다면
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				answer[stack.pop()] = arr[i];
			}
			
			//현재 값 stack에 넣기
			stack.add(i);
		}
		
		//출력
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<answer.length; i++) {
			sb.append(answer[i]+" ");
		}
		
		System.out.println(sb.toString());
	}
}
