import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n==1) {
			System.out.println(1);
			return;
		} else if(n==2) {
			System.out.println(2);
			return;
		}
		
		//dp 계산
		long[] dp = new long[n+1];
		dp[1]=1; 
		dp[2]=2;
		
		for(int i=3; i<n+1; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%15746;
		}
		
		//출력
		System.out.println(dp[n]);
	}
}
