import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();			//나무의 개수
		long length = sc.nextLong();	//가져가고 싶은 나무의 길이
		
		long min = 0;
		long max = 0;
		
		long[] tree = new long[n];
		for(int i=0; i<tree.length; i++) {
			tree[i] = sc.nextLong();
			if(max<tree[i]) max = tree[i];
		}
		
		long answer = 0;
		
		//투포인터
		while(min<=max) {
			long mid = (min+max)/2;
			
			long sum = 0;
			for(int i=0; i<tree.length; i++) {
				if(mid <= tree[i]) sum+=(tree[i]-mid);
			}	
			
			if(sum<length) max = mid-1;			//원하는 만큼 나무가 잘리지 않았을 때
			else {								//원하는 것 이상 나무가 잘렸을 때
				min = mid+1;
				answer = Math.max(mid, answer);
			}
		}
		
		
		//출력
		System.out.println(answer);
				
	}
}	
