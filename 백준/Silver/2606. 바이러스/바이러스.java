import java.util.*;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		parent = new int[n+1];
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		//컴퓨터 연결하기
		int m = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			union(x, y);
		}
		
		//연결안된 컴퓨터 연결하기
		for(int i=0; i<parent.length; i++) {
			parent[i] = find(parent[i]);
		}
		
		
		//1번 바이러스와 연결되어 있는 컴퓨터 개수 구하기
		int answer = -1;
		for(int i=1; i<parent.length; i++) {
			if(parent[i]==1) answer++;
		}
		
        //출력
		System.out.println(answer);
		
	}
	
	//유니온
	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px<py) parent[py]=parent[px];
		else parent[px]=parent[py];
	}
	
	//파인드
	public static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x]=find(parent[x]);
	}
}
