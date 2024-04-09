import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//게임 횟수
		Long x = sc.nextLong();	
		
		//이긴 횟수
		Long y = sc.nextLong();	
		
		//이긴 승률
		Long win = (y*100)/x;	
		
		//이분탐색
		Long answer = Long.MAX_VALUE;
		
		Long min = 0L;
		Long max = 1000000000L;
		
		while(min<=max) {
			Long mid = (min+max)/2;

			if(((mid+y)*100/(mid+x))<=win) min = mid+1;
			else {
				answer = Math.min(answer, mid);
				max = mid-1;
			}
		}
		
		//출력
		if(answer==Long.MAX_VALUE) System.out.println(-1); 
		else System.out.println(answer);
	}
}
