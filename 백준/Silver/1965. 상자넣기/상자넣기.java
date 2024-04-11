import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//상자 정보 입력받기
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//dp
		int[] dp = new int[n];
		Arrays.fill(dp, 1);;
		
		//LIS
		for(int i=1; i<n; i++) {
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		//최대값 찾기
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		//출력
		System.out.println(max);
		
	}
}
