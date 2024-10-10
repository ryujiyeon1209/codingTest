import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n+1][2];
		for(int i=1; i<arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int[][] dp = new int[n+1][m+1];
		
		//현재 물건
		for(int i=1; i<n+1; i++) {
			//가방 무게 
			for(int j=1; j<m+1; j++) {
				int weight = arr[i][0];
				
				//가방 무게가 물건보다 작다면, 다른 물건 넣기
				if(j<weight) {
					dp[i][j] = dp[i-1][j];
				}	
				
				//가방에 현재 물건을 넣을 수 있다면, 현재 물건 가치+남는 공간 최대 가치 활용
				//i-1인 이유 : 현재 물건의 가치가 영향이 있으면 안되므로
				else {
					dp[i][j]= Math.max(dp[i-1][j], arr[i][1]+dp[i-1][j-weight]);
				}
				
			}
		}
		
		//출력
		System.out.println(dp[n][m]);
	}
}
