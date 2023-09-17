import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//배열 생성 및 값 초기화
		long[][] arr = new long[n+1][11];
		for(int i=0; i<10; i++) arr[1][i]=1;
		arr[1][10]=10;
		
		
		for(int i=2; i<arr.length; i++) {
			
			long sum= 0;
			for(int j=0; j<10; j++) {
				if(j==0) arr[i][j] = arr[i-1][10];
				else arr[i][j] = arr[i][j-1]-(arr[i-1][j-1]%10007);
				
				sum+=(arr[i][j]%10007);
			}
			
			arr[i][10]=sum;
		}
		
		//출력
		System.out.println(arr[n][10]%10007);
	}
}
