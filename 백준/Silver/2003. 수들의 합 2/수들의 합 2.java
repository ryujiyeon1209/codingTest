import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//숫자 개수
		int n = sc.nextInt();
		
		//더해서 나와야 하는 수
		int m = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//완전 탐색
		int count=0;				//m이 되는 경우의 수
		for(int i=0; i<arr.length; i++){
			
			int sum=0;				//수열의 합
			for(int j=i; j<arr.length; j++) {
				if(sum==m) { count++; break;}
				else {sum+=arr[j]; }
				
				if(sum==m) { count++; break;}
			}
		}
		
		//출력
		System.out.println(count);
		
	}
}
