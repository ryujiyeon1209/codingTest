import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		
		//조카의 수
		int n = sc.nextInt();
		
		//과자의 수
		int m = sc.nextInt();
		
		//과자 길이 배열
		int[] arr = new int[m];
		for(int i=0; i<m; i++) {
			arr[i] = sc.nextInt();
		}
		
        //정렬
		Arrays.sort(arr);
		
		//이분 탐색 최소 최대값
		int min = 1;
		int max = arr[m-1];
		
		//이분 탐색
		while(min<=max) {
			
			//중간 값
			int mid = (min+max)/2;
			
			//현재 조카들에게 나눠줄 길이
			int length = mid;	
			
			//가능한지 확인
			int count = 0;
			for(int i=m-1; 0<=i; i--) {
				int cur =(int)Math.floor(arr[i]/length);
				count+=cur;
				
				if(cur==0) break;
				else if(n<=count) break;
			}
			
			//가능하다면,
			if(n<=count) {
				answer=length;
				min=mid+1;
			}
			
			//불가능 하다면
			else if(count<n) {
				max = mid-1;
			}
		}
		
		//출력
		System.out.println(answer);
	}
}
