import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//개수 입력받기
		int n = sc.nextInt();

		//지울 수 있는 개수 입력받기
		int remove = sc.nextInt();
	
		//수 입력받기
		String str = sc.next();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(str.substring(i, i+1));
		}
		
		//작은 수 지우기
		Stack<Integer> stack = new Stack();
		for(int i=0; i<arr.length; i++) {
			
			while(0<remove && !stack.isEmpty() && stack.peek() < arr[i]) {
				remove--;
				stack.pop();
			}
			
			stack.add(arr[i]);
		}
		
		//만약 지우지 못했다면, 숫자는 점점 작아지는 형태일 것이므로 가장 뒤의 숫자를 삭제
		while(0<remove) {
			remove--;
			stack.pop();
		}
		
		//출력
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse());
	}
}
