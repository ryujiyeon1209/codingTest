import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
        //올바르지 않은 괄호면 0
		if(!check(str)) {
			System.out.println(0);
			return;
		}
		
		Stack<String> stack = new Stack();
		String[] arr = str.split("");
		
		for(int i=0; i<arr.length; i++) {
			
			String ch = arr[i];
			
            //stack이 비었거나, ([기호라면 stack에 저장
			if(stack.isEmpty()) stack.add(ch);
			else if(ch.equals("(") || ch.equals("[")) stack.add(ch);
			
            //현재 기호가 )이고, 바로 전 기호가 (면 2 저장
			else if(!stack.isEmpty() && ch.equals(")") && stack.peek().equals("(")) {
				stack.pop();
				stack.add("2");
			}
            
            //현재 기호가 ]이고, 바로 전 기호가 [면 3 저장
			else if(!stack.isEmpty() && ch.equals("]") && stack.peek().equals("[")) {
				stack.pop();
				stack.add("3");
			}
			
            //현재 기호가 )인데, 바로 전 기호가 (가 아닐 경우
			else if(!stack.isEmpty() && ch.equals(")") && !stack.peek().equals("(")) {
				int tmp = 0;
				while(!stack.isEmpty() && ch.equals(")") && !stack.peek().equals("(")) {
					tmp+=(Integer.parseInt(stack.pop()));
				}
				stack.pop();
				stack.add(String.valueOf(tmp*2));
			}
		
            //현재 기호가 ]인데, 바로 전 기호가 [가 아닐 경우
			else if(!stack.isEmpty() && ch.equals("]") && !stack.peek().equals("[")) {
				int tmp = 0;
				while(!stack.isEmpty() && ch.equals("]") && !stack.peek().equals("[")) {
					tmp+=(Integer.parseInt(stack.pop()));
				}
				stack.pop();
				stack.add(String.valueOf(tmp*3));
			}
		}
			
		int answer = 0;
		while(!stack.isEmpty()) {
			answer+=(Integer.parseInt(stack.pop()));
		}
        
        System.out.println(answer);
	}
	
	
	public static boolean check(String str) {
		
		Stack<Character> stack = new Stack();
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if(stack.isEmpty()) stack.add(ch);
			else if(!stack.isEmpty() && ch==')' && stack.peek()=='(') {
				stack.pop();
			}
			else if(!stack.isEmpty() && ch==']' && stack.peek()=='[') {
				stack.pop();
			}
			else if(stack.isEmpty() && ch==')') {
				return false;
			}
			else if(stack.isEmpty() && ch==']') {
				return false;
			}
			else {
				stack.add(ch);
			}
		}
		
		if(!stack.isEmpty()) return false;
		return true;
	} 
}
