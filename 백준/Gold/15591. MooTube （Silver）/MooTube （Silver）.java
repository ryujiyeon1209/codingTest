import java.util.*;

public class Main {
	
	static List<int[]>[] map;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		map = new ArrayList[n+1];
		for(int i=0; i<map.length; i++) {
			map[i] = new ArrayList<int[]>();
		}
		
		//연결리스트 만들기
		for(int i=0; i<n-1; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int u = sc.nextInt();
			
			map[v1].add(new int[] {v2, u});
			map[v2].add(new int[] {v1, u});
		}

		//유사도 체크
		for(int i=0; i<q; i++) {
			int k = sc.nextInt();	//유사도
			int v = sc.nextInt();	//비디오 번호
			
			count = 0;
			DFS(v, k, 0);
			
			//출력
			System.out.println(count);
		}
	}
	
	
	public static void DFS(int v, int k, int isloop) {
		
		if(map[v].size()<=0) return;
		
		for(int i=0; i<map[v].size(); i++) {
			int[] connect = map[v].get(i);
			
			int video = connect[0];
			int usado = connect[1];
			
			//무한반복문을 방지하기 위한 조건문
			if(video==isloop) {
				continue;	
			}
			
			if(k<=usado) count++;
			if(k<=usado && 0<map[video].size()) DFS(video, k, v);
		}
	
	}
}
