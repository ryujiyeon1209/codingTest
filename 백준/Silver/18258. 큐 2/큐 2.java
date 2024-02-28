import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> queue = new LinkedList();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); 
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			//push
			if(str.equals("push")) queue.add(Integer.parseInt(st.nextToken()));
			
			//pop
			else if(str.equals("pop") && queue.isEmpty()) sb.append("-1\n");
			else if(str.equals("pop") && !queue.isEmpty()) sb.append(queue.poll()+"\n");
			
			//size
			else if(str.equals("size")) sb.append(queue.size()+"\n"); 
			
			else if(str.equals("empty") && queue.isEmpty()) sb.append("1\n");
			else if(str.equals("empty") && !queue.isEmpty()) sb.append("0\n");
			
			//front
			else if(str.equals("front") && !queue.isEmpty()) sb.append(queue.peek()+"\n");
			else if(str.equals("front") && queue.isEmpty()) sb.append("-1\n");
			
			//back
			else if(str.equals("back") && queue.isEmpty()) sb.append("-1\n");
			else if(str.equals("back") && !queue.isEmpty()) sb.append(queue.peekLast()+"\n");
			
		}
		
		//출력
		System.out.println(sb.toString());
	}
}
