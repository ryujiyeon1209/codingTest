import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//1, 2, 3일 경우
		if(n==1 || n==2) {
			System.out.println(1);
			return;
		} else if(n==3) {
			System.out.println(2);
			return;
		}
		
		//dp 배열 생성
		long[][] dp = new long[2][n+1];
		dp[0][1] = 1;   dp[1][1] = 1;
		dp[0][2] = 1;   dp[1][2] = 2;
		dp[0][3] = 2;   dp[1][3] = 4;   
		
		//계산
		//0행 : 현재 자리수가 가질 수 있는 이친수의 개수
		//1행 : 1의 자리수부터 현재 자리수까지 가질 수 있는 이친수 개수의 누적 합
		for(int i=4; i<n+1; i++) {
			dp[0][i] = dp[1][i-2]+1;
			dp[1][i] = dp[1][i-1]+dp[0][i];
		}
		
		//출력
		System.out.println(dp[0][n]);
	}
}
