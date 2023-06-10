import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//지방 개수 입력받기
		int n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		int[] arr =new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//국가 예산 입력받기
		int m = sc.nextInt();
		
		//배열 정렬
		Arrays.sort(arr);
		
		int max=arr[arr.length-1];	//상한선
		int answer=0;				//정답변수
		
		//완전 탐색
		for(int i=max; i>=1; i--) {
			int sum=0;
			for(int j=0; j<arr.length; j++) {
				if(arr[j]<=i) sum+=arr[j];
				else sum+=i;
			}
			if(sum<=m) { answer=i; break;}
		}
		
		//출력
		System.out.println(answer);
	}
}
