import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] time  = new int[n+2];
		int[] price = new int[n+2];
		for(int i=1; i<n+1; i++) {
			time[i] = sc.nextInt();
			price[i] = sc.nextInt();
		}
		
		int max = 0;
		int[] dp = new int[n+2];
		for(int i=1; i<n+2; i++) {
			
			//현재 시점에서 내가 얻을 수 있는 가장 큰 값
			if(max<dp[i]) max = dp[i];	
			
			int day = i+time[i];
			if(day<n+2) {
				dp[day] = Math.max(max+price[i], dp[day]);
			}
		}
		
        //출력
        System.out.println(max);
	}
}
