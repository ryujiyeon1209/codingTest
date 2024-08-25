import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//개수 세기
		int[] count = new int[d+1];
		for(int i=0; i<k; i++) {
			count[arr[i]]++;
		}
		
		int countz = 0;
		for(int i=0; i<count.length; i++) {
			if(0<count[i]) countz++;
		}
		
		int answer = 0;
		for(int i=1; i<arr.length+1; i++) {
			
			//연속되는 k개의 초밥을 먹은 경우
			if(count[c]==0) answer = Math.max(answer, countz+1);
			else answer = Math.max(answer, countz);
			
            //초밥 연결시키기
			if(--count[arr[i-1]]==0) countz--;
			
			int end = (i+k-1)%n;  
			if(++count[arr[end]]==1)countz++;
		}
		
		//출력
		System.out.println(answer);
		
	}
}
