import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
			
			else if(str.equals("pop") && stack.isEmpty()) System.out.println("-1");
			else if(str.equals("pop") && !stack.isEmpty()) System.out.println(stack.pop());
			
			else if(str.equals("size")) System.out.println(stack.size());
			
			else if(str.equals("empty") && stack.isEmpty()) System.out.println("1");
			else if(str.equals("empty") && !stack.isEmpty()) System.out.println("0");
			
			else if(str.equals("top") && stack.isEmpty()) System.out.println("-1");
			else if(str.equals("top") && !stack.isEmpty()) System.out.println(stack.peek());
		}
	}
}
