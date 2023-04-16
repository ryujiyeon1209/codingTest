import java.util.*;

public class Main {

	static int[][] arr;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정점 개수
		int n = sc.nextInt();
	
		//간선 개수
		int m = sc.nextInt();
		
		//유니온 배열 생성 및 초기화
		parent = new int[n+1];
		for(int i=0; i<n+1; i++) {
			parent[i]=i;
		}
		
		//그래프 생성
		arr= new int[m][3];

		//간선 만들기
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();	//정점1
			int y = sc.nextInt();	//정점2
			int z = sc.nextInt();	//그래프 비용
			
			arr[i][0]=x;
			arr[i][1]=y;
			arr[i][2]=z;
		}
		
		//그래프 비용을 기준으로 오름차순 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		//컴퓨터 연결하기
		int result=0;
		for(int i=0; i<m; i++) {
			int x = arr[i][0];	//정점1
			int y = arr[i][1];	//정점2
			
			//부모가 같지 않다면, 비용 더하고 합집합 만들기
			if(findset(x)!=findset(y)) {
				union(x, y);
				result+=arr[i][2];
			}
		}
		
		//출력
		System.out.println(result);
	}
	
	
	//부모찾기 메서드
	public static int findset(int x) {
		if(parent[x]!=x) parent[x]=findset(parent[x]);
		return parent[x];
	}
	
	
	//합집합 만들기 메서드
	public static void union(int x, int y) {
		int dx = findset(x);
		int dy = findset(y);
		
		if(dx>dy) parent[dx]=dy;
		else parent[dy]=dx;
	}
}	
