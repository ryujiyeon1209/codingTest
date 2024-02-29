import java.util.*;

public class Main {
	
	static String[][] map;
	static int[] r, c;
	static int n;
	static String result;
	static List<Node> xList, tList;
	static Node[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		//입력받기
		map = new String[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.next();
			}
		}
		
		//사방향 탐색 배열
		r = new int[] {-1, 0, 1, 0};
		c = new int[] {0, 1, 0, -1};

		//빈공간, 선생님 좌표 list에 저장
		xList = new ArrayList();
		tList = new ArrayList();
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j].equals("T")) tList.add(new Node(i, j));
				else if(map[i][j].equals("X")) xList.add(new Node(i, j));
			}
		}
		
		//장애물을 놓을 좌표 배열
		sel = new Node[3];
		
		//DFS 실행
		result = "NO";
		DFS(0, 0);
		
		//출력
		System.out.println(result);		
	}
	
	
	//완전 탐색
	public static void DFS(int depth, int idx) {
		
		if(depth==3) {	
			if(BFS()) result = "YES";
			return;
		}

		if(idx==xList.size()) return;
		
		sel[depth] = xList.get(idx);
		DFS(depth+1, idx+1);			//현재 자리를 선택하고, 다음 자리를 탐색한다.
		
		DFS(depth, idx+1);				//현재 자리를 선택하지 않고, 다음 자리를 탐색한다.
	}
	
	
	//BFS
	public static boolean BFS() {
		
		//map 배열 복사
		String[][] copy = new String[n][n];
		for(int i=0; i<map.length; i++) {
			copy[i] = map[i].clone();
		}
		
		//장애물 설치
		for(int i=0; i<sel.length; i++) {
			Node node = sel[i];
			copy[node.x][node.y] = "O";
		}
		
		
		//선생님 탐색
		for(int i=0; i<tList.size(); i++) {
			Node node = tList.get(i);
			
			for(int k=0; k<4; k++) {
				int dr = node.x;
				int dc = node.y;
				
				while(true) {
					dr +=r[k]; 
					dc +=c[k];
					
					if(!(0<=dr && dr<n && 0<=dc && dc<n)) break;
					if(copy[dr][dc].equals("O")) break;
					
					if(copy[dr][dc].equals("S")) return false;
				}
			}
		}

		return true;
		
	}
}


//좌표 class
class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
}
