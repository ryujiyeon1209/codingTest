import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//설탕 무게 입력받기
		int n = sc.nextInt();	
	
		//봉지의 값을 담을 배열 생성 및 초기화
		int[] dp = new int[50001];
		dp[3]=1; dp[5]=1;
		
		for(int i=4; i<n+1; i++) {
			if(i%5==0) dp[i]=dp[i-5]+1;			//5kg으로 나눠질 때
			else if(i%3==0) dp[i]=dp[i-3]+1;	//3kg로 나눠질 때
			else if(dp[i-3]!=0 && dp[i-5]!=0) {
				dp[i]=Math.min(dp[i-3], dp[i-5])+1;	//5kg와 3kg로 나눠떨어지지 않을 때
			}
		}
		
		//출력
		if(dp[n]>0) System.out.println(dp[n]);
		else System.out.println(-1);
	
	}
}
