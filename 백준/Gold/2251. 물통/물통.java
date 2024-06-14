import java.util.*;

public class Main {
	
	static int[] arr;
	static Set<Integer> set;
	static boolean[][] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		arr = new int[3];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		set = new HashSet();
		isvisited = new boolean[arr[0]+1][arr[1]+1];
		
		//DFS
		DFS(0, 0, arr[2]);
		
		//출력
		List<Integer> list = new ArrayList(set);
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	
	//DFS
	public static void DFS(int A, int B, int C) {
				
		if(isvisited[A][B]) return;
		isvisited[A][B]=true;
			
		int spaceA = arr[0]-A;
		int spaceB = arr[1]-B;
		int spaceC = arr[2]-C;
		
		if(0<A) {
			//A -> B
			int bw = Math.min(A, spaceB);
			DFS(A-bw, B+bw, C);
			
			//A -> C
			int cw = Math.min(A, spaceC);
			DFS(A-cw, B, C+cw);
		}
		
		if(0<B) {
			//B -> A
			int aw = Math.min(B, spaceA);
			DFS(A+aw, B-aw, C);
			
			//B -> C
			int cw = Math.min(B, spaceC);
			DFS(A, B-cw, C+cw);
		}
		
		if(0<C) {
			//C -> A
			int aw = Math.min(C, spaceA);
			DFS(A+aw, B, C-aw);
			
			//C -> B 
			int cw = Math.min(C, spaceB);
			DFS(A, B+cw, C-cw);
		}
		
		//만약 A 물통의 양이 0이 되면 재귀 멈추기
		if(A==0) {
			set.add(C);
			return;
		}
	}
}
