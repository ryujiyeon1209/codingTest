
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0; t<10; t++) {
			
			int tc = sc.nextInt();
			
			int num = sc.nextInt();	//제곱할 숫자
			int m = sc.nextInt();	//제곱 횟수
			
			int answer = square(num, m);
			System.out.printf("#%d %d\n", (tc), answer);
			
		}		
	}
	
	public static int square(int num, int m) {
		
		if(m==1) return num;
		
		if(m%2==0) {	//짝수일 때, 거듭제곱 공식(ex. 2^8 = 2^4 * 2^4) 
			int result = square(num, m/2);
			return result*result;
		}
		
		else {	//홀수일 때, 거듭제곱 공식(ex. 2^9 = 2^4 * 2^4 * 2) 
			int result = square(num, m/2);
			return result*result*num;
		}
	}
}
