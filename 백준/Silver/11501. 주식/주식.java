import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			//예측 가능한 날짜의 수
			int n = sc.nextInt();
			
			int[] stock = new int[n];
			for(int i=0; i<n; i++) {
				stock[i]=sc.nextInt();
			}
			
			long profit=0;    //이득
			long max=0;       //주식 최고가
			
			for(int i=stock.length-1; i>=0; i--) {
				if(max<stock[i]) max=stock[i];
				else profit+=(max-stock[i]);
			}

			//출력
			System.out.println(profit);
			
		}
	}
}
