import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//온도를 측정한 전체 날짜의 수 입력받기
		int n = sc.nextInt();
		
		//연속적인 날짜 입력받기
		int k = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}

		//sum 초기화
		int sum=0;
		for(int i=0; i<k; i++) {
			sum+=arr[i];
		}
		
		//슬라이딩 알고리즘
		int max=sum;
		for(int i=0; i<n-k; i++) {
			sum-=arr[i];
			sum+=arr[i+k];
			
			max=Math.max(max, sum);
		}
		
		//출력
		System.out.println(max);
		
	}
}
