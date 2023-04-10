import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int[] problem;
	static boolean[] isvisited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//문제 개수 입력받기
		int n = sc.nextInt();
		
		//선행문제 개수 입력받기
		int m = sc.nextInt();
		
		//선행문제 개수를 담을 배열
		problem = new int[n+1];
		
		//인접리스트 생성
		List<Integer>[] list = new ArrayList[n+1]; 
		for(int i=0; i<list.length; i++) {
			list[i]=new ArrayList();
		}
		
		//선행문제 입력받기 > 인접리스트 만들기
		for(int i=0; i<m; i++) {
			int before = sc.nextInt();
			int after = sc.nextInt();
			
			list[before].add(after);	//몇번 문제를 먼저 풀어야 하는지 나타내기
			problem[after]++;			//선행문제가 몇개인지 나타내기
		}
		
		//방문 처리 배열
		isvisited = new boolean[n+1];
		
		//위상정렬 실행!
		Solution(list);
		System.out.println(sb.toString());
	}
	
	//위상정렬
	public static void Solution(List<Integer>[] list) {
		
		//큐생성
		PriorityQueue<Integer> queue = new PriorityQueue();
		
		//출력을 위한 스트링 빌더
		sb = new StringBuilder();
		
		//선행 문제가 없으면 큐에 문제 번호 넣기(쉬운 문제 부터 넣기 > 우선순위 큐 사용!)
		for(int i=1; i<problem.length; i++) {
			if(problem[i]==0) {
				queue.offer(i);
				isvisited[i]=true;
			}
		}
		
		while(!queue.isEmpty()) {
			
			//큐에서 문제를 꺼내고
			int curr = queue.poll();
			sb.append(curr + " ");
			
			//이 문제가 선행문제였다면 problem에서 -1 해주기
			for(int i=0; i<list[curr].size(); i++) {
				int end = list[curr].get(i);		//내가 방금 끝내서 큐에서 뺀 문제 번호
				problem[end]=problem[end]-1;		
			}
			
			//problem이 0이되면 또 큐에 넣기(방문 하지 않았던 문제로!)
			for(int i=1; i<problem.length; i++) {
				if(problem[i]==0 && !isvisited[i]) {
					queue.offer(i);
					isvisited[i]=true;
				}
			}
		}
		
	}
}
