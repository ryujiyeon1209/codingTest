import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//계단 개수
		int n = sc.nextInt();
	
		//정보 배열과 dp 배열 생성
		int[] info = new int[n+1];
		int[] dp = new int[n+1];
	
		//계단 점수 입력받기
		for(int i=1; i<=n; i++) {
			info[i]=sc.nextInt();
		}
	
		//여기서 dp배열의 의미는 이 인덱스가 마지막일 때
		//가장 큰 값이 되는 점수의 합
		
		//dp배열 초기화
		dp[1]=info[1];
		
		if(n>=2) dp[2]=info[1]+info[2];
		
		//dp값 구하기
		for(int i=3; i<=n; i++) {
			dp[i]=Math.max(dp[i-2], dp[i-3]+info[i-1])+info[i];
		}

		
		//출력
		System.out.println(dp[n]);
	}
}
