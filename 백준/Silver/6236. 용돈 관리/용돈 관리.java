import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, m, max, sum;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//일 수 입력받기
		n = sc.nextInt();
		
		//돈을 뺄 횟수
		m = sc.nextInt();
		
		max=0;
		
		//큐 생성 및 값 입력받기
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();

			if(max<arr[i]) max=arr[i];
		}
		
		minWithdraw();
	}
	
	//이분탐색
	public static void minWithdraw() {
		
		//최소금액 : 1원
		//최대금액 : 가장 높은 금액 X 일 수
		int low = 1;
		int high = max * n;
		
		int answer = high;
		while(low<=high) {
			int testPrice = (low+high)/2;
			
			boolean flag = isPossible(testPrice);
			
			//testPrice로 버틸 수 있다면 인출값 줄이기
			if(flag) {
				high=testPrice-1;
				answer = Math.min(answer, testPrice);
				
			//버틸 수 없거나, m이 크다면 인출값 늘리기
			} else {
				low = testPrice+1;
			}
		}
		
		//출력
		System.out.println(answer);
	}
	
	
	public static boolean isPossible(int testPrice) {
		
		int remain=testPrice;
		
		int cnt=1;
		for(int i=0; i<n; i++) {
			
			//해당 금액으로 하루라도 버티지 못하면 false
			if(testPrice<arr[i]) return false;
			
			//돈이 부족하다면
			if(remain-arr[i]<0) {
				remain=testPrice;
				cnt++;
			}
			
			remain-=arr[i];
		}
		
		return cnt<=m;
	}
}
