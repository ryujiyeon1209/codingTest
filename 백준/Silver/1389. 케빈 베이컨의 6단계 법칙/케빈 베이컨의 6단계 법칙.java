
import java.util.*;

public class Main {
	
	static int result;
	static List<Integer>[] list;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//유저의 수
		int n = sc.nextInt();
	
		//친구 관계의 수
		int m = sc.nextInt();
		
		//인접리스트 생성 및 초기화 (사람 번호가 1번부터 시작)
		list = new List[n+1];
		for(int i=0; i<list.length; i++) {
			list[i]=new ArrayList();
		}
		
		//친구관계 입력받기
		for(int i=0; i<m; i++) {
			int friend1 = sc.nextInt();
			int friend2 = sc.nextInt();
			
			list[friend1].add(friend2);
			list[friend2].add(friend1);
		}
		
		//최소값 구하기
		int min=Integer.MAX_VALUE;
		int user=0;
		
		
		//DFS실행
		for(int i=1; i<=n; i++) {

			int sum=0;
			for(int j=1; j<=n; j++) { 
				
				//방문체크 배열
				isvisited = new boolean[n+1];
				BFS(new int[] {i, 0}, j); 
				sum+=result;
			}
			
			if(sum<min) {min=sum; user=i;}
		}
		
		//출력
		System.out.println(user);
	}
	
	
	public static void BFS(int[] search, int end) {
		
		//큐 생성
		Queue<int[]> queue = new LinkedList();
		
		//큐에 최초 값 넣고 방문체크하기
		queue.offer(search);
		isvisited[search[0]]=true;
		
		while(!queue.isEmpty()) {
			
			//현재 값
			int[] curr = queue.poll();
			
			int start = curr[0];	//탐색하는 사람
			int depth= curr[1];		//단계
			
			//현재 값이 찾는 사람이라면, 반복문 멈추기
			if(start==end) { result=depth; return;}
			
			//아니라면 탐색 계속하기
			for(int i=0; i<list[start].size(); i++) {
				
				//이미 방문했다면 멈추기 
				if(isvisited[list[start].get(i)]) continue;
				
				queue.add(new int[] {list[start].get(i), depth+1});
				isvisited[list[start].get(i)]=true;
			}
		}
	}
}
