import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//랜선의 개수와 필요한 개수 입력받기
		int n = sc.nextInt();
		Long m = sc.nextLong();
		
		//랜선의 길이 입력받기
		Long[] arr = new Long[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextLong();
		}
		
		//최대값 구하기
		Long min = 1L;
		Long max = 0L;
		for(int i=0; i<n; i++) {
			if(max<arr[i]) max = arr[i];
		}
		
		//이분탐색
		Long mid = (min+max)/2;
		Long answer = 0L;
		
		while(min<=max) {
			mid = (min+max)/2;
			
			int result = 0;
			for(int i=0; i<arr.length; i++) {
				result+=arr[i]/mid;
			}
	
			if(result<m) max = mid-1;
			else if(m<=result) {
				answer = Math.max(answer, mid);
				min = mid+1;
			}
		}
		
		//출력
		System.out.println(answer);
	}
}
