import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			//괄호 문자 입력받기
			String str = sc.next();
			
			//문자 배열로 전환
			char[] ch = str.toCharArray();
			
			String answer="YES";
			
			//스택 생성
			Stack<Character> stack = new Stack();
			
			//올바른 괄호인지 확인
			for(int i=0; i<ch.length; i++) {
				if(ch[i]=='(') stack.push('(');
				else if(ch[i]==')') {
					if(stack.isEmpty()) answer="NO";
					else stack.pop();
				}
			}
			
			if(!stack.isEmpty()) answer="NO";
			
			//출력
			System.out.println(answer);
		}
	}
}
