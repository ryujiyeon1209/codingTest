import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력 범위가 1<= n <=100
		long[] dp = new long[101];
		
		//기본 값 설정
		dp[1]=1; dp[2]=1; dp[3]=1;
		dp[4]=2; dp[5]=2;
		
		//dp배열 값 채우기
		for(int i=6; i<dp.length; i++) {
			dp[i]=dp[i-1]+dp[i-5];
		}
		
		//테스트케이스 입력받기
		int T = sc.nextInt();
		
		//dp배열에서 값 출력
		for(int t=0; t<T; t++) {
			int num = sc.nextInt();
			System.out.println(dp[num]);
		}
	}
}
