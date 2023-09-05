import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 개수
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			char[] chList = sc.next().toCharArray();
			
			Stack<Character> stack = new Stack();	//알파벳 stack
			Stack<Character> tmp = new Stack();		//화살표에 따른 stack
			
			for(int j=0; j<chList.length; j++) {
				if(chList[j]=='<' && !stack.isEmpty()) tmp.add(stack.pop());		//왼쪽 화살표, 알파벳을 stack에서 tmp로 이동시키기
				else if(chList[j]=='>' && !tmp.isEmpty()) stack.add(tmp.pop());		//오른쪽 화살표, 알파벳을 tmp에서 stack으로 옮기기
				else if(chList[j]=='-' && !stack.isEmpty()) stack.pop();			//삭제, stack에서 알파벳 지우기
				else if(chList[j]!='<' && chList[j]!='>' && chList[j]!='-') stack.add(chList[j]);	//stack에 알파벳 넣기
			}
			
			
			//남은 알파벳 sb에 담기
			StringBuilder sb = new StringBuilder();
			
			while(!tmp.isEmpty()) stack.add(tmp.pop());
			while(!stack.isEmpty()) sb.append(stack.pop());

			//출력
			System.out.println(sb.reverse().toString());	
		}	
		
	}
}
