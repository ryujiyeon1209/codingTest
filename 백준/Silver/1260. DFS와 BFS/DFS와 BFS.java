import java.util.*;

public class Main {
	
	static int n;
	static boolean[] isvisited;
	static List<Integer>[] list; 
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		//인접리스트 생성
		list = new ArrayList[n+1];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList();
		}
		
		//인접리스트 값 저장
		for(int i=0; i<m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			list[node1].add(node2);
			list[node2].add(node1);
		}
		
		//정렬
		for(int i=0; i<list.length; i++) {
			Collections.sort(list[i]);
		}
		
		//DFS, BFS 실행
		sb = new StringBuilder();
		
		isvisited = new boolean[n+1];
		isvisited[start]=true;
		DFS(start);
		
		isvisited = new boolean[n+1];
		BFS(start);
		
		//출력
		System.out.println(sb.toString());
	}
	
	//DFS
	public static void DFS(int node) {
		
		sb.append(node+ " ");
		
		for(int i=0; i<list[node].size(); i++) {
			int next = list[node].get(i);
			if(isvisited[next]) continue;
			
			isvisited[next]=true;
			DFS(next);
		}
	}
	
	
	//BFS
	public static void BFS(int start) {	
		Queue<Integer> queue = new LinkedList();
		queue.add(start);
		
		isvisited[start]=true;
		
		sb.append("\n");
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			sb.append(cur+ " ");
			
			for(int i=0; i<list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(isvisited[next]) continue;
				
				isvisited[next]=true;
				queue.add(next);
			}
		}
		
	}
}
