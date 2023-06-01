import java.util.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		int n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		Long[] arr = new Long[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextLong();
		}

		//정렬
		Arrays.sort(arr);
		
		int sum=0;
		
		//투포인터		
		for(int i=0 ; i<n ; i++) {
			int left = 0;
			int right = n-1;
			
			while(true) {
				//현재 위치가 자기 자신인 경우
				if(left==i) left++;
				else if(right==i) right--;
				
				//좋은 수가 아닌 경우
				if(left>=right) break;
				
				//좋은 수를 찾아가는 과정
				if(arr[left]+arr[right]<arr[i]) left++;
				else if(arr[left]+arr[right]>arr[i]) right--;
				
				//좋은 수를 찾은 경우
				else { sum++; break;}
			}
		}
		
		
		//출력
		System.out.println(sum);
	}
}
