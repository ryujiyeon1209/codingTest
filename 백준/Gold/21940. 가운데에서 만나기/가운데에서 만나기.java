import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//인접배열 생성
		int[][] map = new int[n+1][n+1];
		for(int i=0; i<n+1; i++) {		
			for(int j=0; j<n+1; j++) {	
				if(i==j) continue;
				map[i][j] = (n*m)+1;
			}
		}
		
		//거리 입력받기
		for(int i=0; i<m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int distance = sc.nextInt();
			
			map[start][end] = distance;
		}

		//플로이드-와샬 
		for(int k=1; k<n+1; k++) {			//경유지
			for(int i=1; i<n+1; i++) {		//출발지
				for(int j=1; j<n+1; j++) {	//출발지
					if(i==j) continue;
					map[i][j] = Math.min(map[i][j], (map[i][k]+map[k][j]));
				}
			}
		}
		
		int x = sc.nextInt();
		int[] arr = new int[x];
		for(int i=0; i<x; i++) {
			arr[i] = sc.nextInt();
		}
		
		//최단거리 찾기
		int min = Integer.MAX_VALUE;
		
		int[] max = new int[n+1];
		for(int i=1; i<n+1; i++) {		
			for(int j=0; j<arr.length; j++) {	
				max[i] = Math.max(max[i], map[arr[j]][i]+map[i][arr[j]]);
			}
			
			min = Math.min(min, max[i]);
		}
		
		//최소값으로 갈 수 있는 도시 list
		ArrayList<Integer> result = new ArrayList();
		for(int i=1; i<n+1; i++) {
			if(max[i]<=min)result.add(i);
		}
		
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		
		//출력
		System.out.println(sb.toString());
	}

}
