
import java.util.*;
import java.util.Scanner;

//Queue로 풀어보기!
public class Solution {	
	
	static int[][] arr;
	static int[] indegree;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0; t<10; t++) {
			
			int v = sc.nextInt();	//정점의 개수
			int e = sc.nextInt();	//간선의 개수
			
			arr = new int[v+1][v+1];	//그래프 인접행렬로 만들기
			indegree = new int[v+1];		//집입차수 배열 만들기	
			
			for(int i=0; i<e; i++) {
				int start = sc.nextInt();	//출발 정점
				int end = sc.nextInt();		//도착 정점
				
				arr[start][end]=1;	//인접해있다고 표시
				indegree[end]++;
			}
			
//			System.out.println(Arrays.deepToString(arr));
//			System.out.println(Arrays.toString(indegree));
			
			sort();
			System.out.printf("#%d %s\n", (t+1), sb.toString());
			
		}
	}
	
	public static void sort() {
		Queue<Integer> queue = new LinkedList();
		sb = new StringBuilder();
		
		//진입차수가 0인 정점을 큐에 넣기
		for(int i=1; i<indegree.length; i++) {	
			if(indegree[i]==0) queue.offer(i);
		}
		
		//큐가 공백이 될 때까지 반복
		while(!queue.isEmpty()) {
			
			//큐에서 값을 꺼내고, 결과 Stringbuilder인 sb에 넣기 
			int curr = queue.poll();	
			sb.append(curr+ " ");
//			System.out.println(curr);
			
			for(int i=1; i<indegree.length; i++) {
				
				//진입차수가 0보다 크다면 진입차수-1을 해주고,
				if(arr[curr][i]>0) { 
					indegree[i]--;	
					
					//그때 진입차수가 0이되면, 큐에 삽입한다
					if(indegree[i]==0) queue.offer(i);
				}
				
			}
			
//			System.out.println(Arrays.deepToString(arr));
//			System.out.println(Arrays.toString(indegree));
		}
	}
	
}
