import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[n];
		
		for(int i=0; i<dp.length-1; i++) {
			int jump = arr[i];
			
			if(jump==0 && dp[i+1]==0) break;	//점프를 할 수 없는 칸+점프로 도달 할 수 없는 다음 칸
			
			for(int j=1; j<=jump; j++) {
				if(arr.length<=(i+j)) break;
				
				if(dp[i+j]==0) dp[i+j]=dp[i]+1;	//처음 도달한 칸이라면
				else if(dp[i+j]!=0)dp[i+j]= Math.min(dp[i+j], dp[i]+1);	//점프로 도달했었던 칸이라면,
			}
		}
		
        if(n==1) System.out.println(0);
		else if(0<dp[n-1]) System.out.println(dp[n-1]);
		else System.out.println(-1);
	}
}
