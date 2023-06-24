import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		int n = sc.nextInt();
		
		//2차원배열 생성 및 값 입력받기
		int[][] arr = new int[2][n+1];
		for(int i=1; i<n+1; i++) {
			arr[0][i]=sc.nextInt();
		}
		
		
		//누적합 만들기
		for(int i=1; i<n+1; i++) {
			int tmp = arr[0][i];	//현재 값
			
			int max=0;
			for(int j=i-1; j>=i/2; j--) {	//현재 인덱스 i가 나오는 j의 값을 더하기
				max = Math.max(max, arr[1][j]+arr[1][i-j]);
			}
			
			arr[1][i]=Math.max(tmp, max);
		}
		
		//출력
		System.out.println(arr[1][n]);
		
	}
}
