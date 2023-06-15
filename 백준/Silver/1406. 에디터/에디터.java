import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//문자열 입력받기
		String str = sc.next();
		
		//스택 생성 및 초기화
		Stack<Character> stack = new Stack();
		for(int i=0; i<str.length(); i++) {
			stack.add(str.charAt(i));
		}
		
		//임시 스택 생성
		Stack<Character> tmp = new Stack();
		
		
		//명령어의 개수 입력받기
		int m = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			String type = sc.next();
			
			if(type.equals("L") && !stack.isEmpty()) {		//커서를 왼쪽으로 옮기기
				tmp.add(stack.pop());
				
			} else if(type.equals("D") && !tmp.isEmpty()) {	//커서를 오른쪽으로 옮기기
				stack.add(tmp.pop());
				
			} else if(type.equals("B") && !stack.isEmpty()) {	//커서 왼쪽 문자를 삭제하기
				stack.pop();
				
			} else if(type.equals("P")) {	//커서 왼쪽에 문자를 추가하기
				char ch = sc.next().charAt(0);
				stack.add(ch);
			}	
		}
		
        //StringBuilder에 문자열 문자열 저장
		StringBuilder sb = new StringBuilder();
        
		while(!stack.isEmpty()) sb.append(stack.pop());
		sb.reverse();
		while(!tmp.isEmpty()) sb.append(tmp.pop());
		
		
		//출력
		System.out.println(sb.toString());
	}
}
