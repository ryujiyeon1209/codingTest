import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//수 입력받기
		int n = sc.nextInt();
		
		//두 수의 차이 입력받기
		int m = sc.nextInt();
	
		//배열 생성 및 값 입력받기
		int[] arr =new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		//정렬하기
		Arrays.sort(arr);
	
		//투포인터
		int left = 0;
		int right = 1;
		
		int result=Integer.MAX_VALUE;
		
		while(right<arr.length) {
			
			int num = arr[right]-arr[left];
			
			//두 수의 차이가 m보다 작을 때
			if(num<m) right++;
			
			//두수의 차이가 m보다 클 때
			else if(num>m) {
				result=Math.min(result, num);
				left++;
			}
			
			//두수의 차이가 m와 같을 때
			else {
				result=m;
				break;
			}
		}
		
		//출력
		System.out.println(result);
	}
}
