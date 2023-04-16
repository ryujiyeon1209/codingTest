import java.util.*;
import java.util.Scanner;

public class Main {
		
	static int n;
	static List<Integer>[] list;
	static int[] arr, semester;
	static boolean[] isvisited;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//과목 개수
		n = sc.nextInt();
		
		//선수과목 조건 개수
		int m = sc.nextInt();
		
		//선수과목 개수 담을 배열
		arr = new int[n+1];
	
		//인접리스트 생성 및 초기화
		list= new List[n+1];
		for(int i=0; i<n+1; i++) {
			list[i]=new ArrayList();
		}
		
		//선수과목 입력받기
		for(int i=0; i<m; i++) {
			int before = sc.nextInt();
			int after = sc.nextInt();
			
			list[after].add(before);
			arr[after]++;
		}
		
		//방문 배열
		isvisited = new boolean[n+1];
		
		//학기 배열
		semester = new int[n+1];
		
		//위상정렬 메서드 호출
		Solution();
		
		//출력
		for(int i=1; i<n+1; i++) {
			System.out.print(semester[i] + " ");
		}	
	}
	
	
	//위상정렬 메서드
	public static void Solution() {
		
		//큐 생성
		Queue<int[]>queue = new LinkedList();
		
		//선수과목이 없는 과목을 큐에 넣기
		for(int i=1; i<n+1; i++) {
			if(arr[i]==0) {
				queue.offer(new int[] {i, 1});
				semester[i]=1;
				isvisited[i]=true;
			}
		}
		
		while(!queue.isEmpty()) {
			
			//현재 과목
			int[] curr = queue.poll();
			
			//과목이랑 학기 
			int subject = curr[0];
			int depth = curr[1];
		
			//이 과목이 선수과목으로 있는 과목이 존재한다면,
			for(int i=1; i<n+1; i++) {
				if(list[i].contains(subject)) arr[i]--;
			}
			
			//다시 선수과목이 존재하지 않는 과목 큐에 넣기
			for(int i=1; i<n+1; i++) {
				if(!isvisited[i] && arr[i]==0) {
					queue.offer(new int[] {i, depth+1});
					semester[i]=depth+1;
					isvisited[i]=true;
				}
			}
		}
	}	
}
