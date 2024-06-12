import java.util.*;

public class Main {
	
	static String answer;
	static Node_9205[] map;
	static List<Integer>[] list;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=0; t<test; t++) {
			int store = sc.nextInt();
			
			map = new Node_9205[store+2];
			
			for(int i=0; i<map.length; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[i] = new Node_9205(x, y);
			}

			//인접리스트
			list = new List[map.length];
			for(int i=0; i<list.length; i++) {
				list[i] = new ArrayList();
			}

			//갈 수 있느 거리 인접리스트에 저장
			for(int i=0; i<map.length; i++) {
				for(int j=i+1; j<map.length; j++) {
					if(!distance(i, j)) continue;
						list[i].add(j);
						list[j].add(i);
				}
			}
			
			answer = "sad";
			isvisited = new boolean[map.length];
			DFS(0);
			
			//출력
			System.out.println(answer);
			
		}
	}
	
	//두 지점의 거리 구하기
	public static boolean distance(int i, int j) {
		int diff = Math.abs(map[i].x-map[j].x)+Math.abs(map[i].y-map[j].y);
		return diff<=1000;
	}
	
	//DFS
	public static void DFS(int idx) {
		
		isvisited[idx] = true;
		for(int i=0; i<list[idx].size(); i++) {
			int node = list[idx].get(i);
			
			if(node==map.length-1) { answer = "happy"; return; }
			if(isvisited[node]) continue;
			
			DFS(node);
		}
	}

}


class Node_9205 {
    int x;
    int y;

    public Node_9205(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


