import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap();
		PriorityQueue<Integer> queue = new PriorityQueue();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
            if(!map.containsKey(num)) queue.add(num);
			map.put(num, 1);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			sb.append(queue.poll()+ "\n");
		}
		
		System.out.println(sb.toString());
	}
}
