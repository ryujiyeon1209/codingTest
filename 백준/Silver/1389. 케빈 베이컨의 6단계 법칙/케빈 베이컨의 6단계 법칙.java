
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//유저의 수
		int n = sc.nextInt();
	
		//친구 관계의 수
		int m = sc.nextInt();
		
		//인접행렬 생성
		map = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			int f1 = sc.nextInt();
			int f2 = sc.nextInt();
			
			map[f1][f2]=1;
			map[f2][f1]=1;
		}
		
		//인접행렬 탐색
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) continue;
				if(map[i][j]==0) continue;
				
				for(int k=1; k<n+1; k++) {
					if(i==k) continue;
					if(map[j][k]!=0 && map[i][k]!=0) {
						map[i][k] = Math.min(map[i][k], map[i][j]+map[j][k]); 
						map[k][i] = Math.min(map[i][k], map[i][j]+map[j][k]); 
					} 
					else if(map[j][k]!=0 && map[i][k]==0) {
						map[i][k] = map[i][j]+map[j][k]; 
						map[k][i] = map[i][j]+map[j][k]; 
					}
				}
			}
		}


		//가장 작은 수 구하기
		int min = Integer.MAX_VALUE;
		for(int i=1; i<n+1; i++) {
			int sum = 0;
			for(int j=1; j<n+1; j++) {
				sum+=map[i][j];
			}
			min = Math.min(min, sum);
		}
		

		int answer = 0;
		for(int i=1; i<n+1; i++) {
			int sum = 0;
			for(int j=1; j<n+1; j++) {
				sum+=map[i][j];
			}
			
			if(min==sum) {
				answer = i;
				break;
			}
		}
		
		//출력
		System.out.println(answer);
	}
}
