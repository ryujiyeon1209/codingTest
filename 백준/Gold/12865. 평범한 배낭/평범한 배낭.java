import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//물건 개수
		int n = sc.nextInt();
		
		//최대 무게
		int k = sc.nextInt();
		
		//물건의 무게와 가치를 담을 배열
		int[][] stuff = new int[n+1][2];
		for(int i=1; i<stuff.length; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			
			stuff[i][0]=w;
			stuff[i][1]=v;
		}
		
		//dp배열 생성 및 반복문 돌리기
		int[][] dp = new int[n+1][k+1];

		for(int i=1; i<dp.length; i++) {			//물건 인덱스
			for(int j=0; j<dp[0].length; j++) {		//물건 무게
				
				//고르지 않는다면,
				if( j<stuff[i][0]) {	dp[i][j]=dp[i-1][j]; }
				
				//고른다면
				else if(j>=stuff[i][0]){
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-stuff[i][0]]+stuff[i][1]);
				}
			}
		}
	
		//출력
		System.out.println(dp[n][k]);
	}
}
