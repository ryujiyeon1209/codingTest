import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//정렬
		Arrays.sort(arr);
		
		//투포인터
		int start = 0;
		int end = n-1;
		
		int result = Integer.MAX_VALUE;
		int ans = 0;
		int ane = n-1;
		
		//최소값 찾기
		while(start<end) {
			
			//두 용액 더하기
			int value = arr[start]+arr[end]; 
			
			//그 값이 0보다 더 가까우면
			if(Math.abs(value)<Math.abs(result)) {
				result = value;
				ans = start;
				ane = end;
			}
			
			//포인터 옮기기
			if(value<0) start++;
			else if(0<value) end--;
			else break;
		}
		
		//출력
		System.out.println(arr[ans] + " " +arr[ane]);
	}
}
