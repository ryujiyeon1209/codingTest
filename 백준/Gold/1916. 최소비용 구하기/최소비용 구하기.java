import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static int c;
	public static int b;
	public static int s;
	public static int e;
	public static int[] money;
	public static boolean[] visit;
	public static ArrayList<Edge> list[];
	public static PriorityQueue<Edge> q= new PriorityQueue<Edge>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		c=Integer.parseInt(br.readLine());
		b=Integer.parseInt(br.readLine());
		
		money= new int[c+1];
		visit= new boolean[c+1];
		list= new ArrayList[c+1];
		
		for(int i=1; i<=c; i++) {
			list[i]=new ArrayList<Edge>();
		}
		
		for(int i=0; i<=c; i++) {
			money[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0; i<b; i++) {
			st=new StringTokenizer(br.readLine());
			
			int u=Integer.parseInt(st.nextToken()); //시작 노드
			int v=Integer.parseInt(st.nextToken()); //도착 노드
			int w=Integer.parseInt(st.nextToken()); //버스 비용
			
			list[u].add(new Edge(v,w));
		}
		
		st=new StringTokenizer(br.readLine());
		s=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		q.add(new Edge(s,0));
		money[s]=0;
		
		while(!q.isEmpty()) {
			Edge current = q.poll();
			int ve=current.vertex;
			if(visit[ve]) continue;
			visit[ve]=true;
			
			for(int i=0; i<list[ve].size(); i++) {
				Edge tmp=list[ve].get(i);
				int next=tmp.vertex;
				int val=tmp.value;
				
				if(money[ve]+val<money[next]) {
					money[next]=money[ve]+val;
					q.add(new Edge(next, money[next]));
				}				
			}
		}
		System.out.println(money[e]);
	}

}

class Edge implements Comparable<Edge>{
	int vertex;
	int value;
	
	Edge(int vertex, int value){
		this.vertex=vertex;
		this.value=value;
	}
	
	public int compareTo(Edge e) {
		if(this.value> e.value)  return 1;
		else return -1;
	}
}