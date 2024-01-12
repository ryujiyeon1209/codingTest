import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		if(n==1) {
			System.out.println(0);
			return;
		} else if(n<=3) {
			System.out.println(1);
			return;
		}
		
		int[] arr = new int[n+1];
		arr[1]=0;
		
		for(int i=2; i<n+1; i++) {
			int tmp = Integer.MAX_VALUE;
			
			//1 : 3으로 나눌 수 있으면 3으로 나눈다.
			if(i%3==0) tmp = Math.min(tmp, arr[i/3]+1); 
				
			
			//2 : 2로 나눌 수 있으면 2로 나눈다.
			if(i%2==0) tmp = Math.min(tmp, arr[i/2]+1); 
			
			//3 : 1을 뺀다.
			tmp = Math.min(tmp, arr[i-1]+1); 
			
			arr[i] = tmp;
		}
		
		//출력
		System.out.println(arr[n]);
	}
}
