import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		int n = sc.nextInt();
	
		//배열 생성 및 값 입력받기
		int[][] arr = new int[3][n];
		for(int i=0; i<n; i++) {
			arr[0][i]=sc.nextInt();	//현재값
		}
		
		//dp
		int max=0;
		for(int i=0; i<n; i++) {
			arr[1][i]=max+arr[0][i];	//누적합+현재값
			
			max=Math.max(arr[1][i], arr[0][i]);	//누적합, 현재값 비교하기
		}
		
		//최대값 찾기
		int result=Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int tmp=Math.max(arr[0][i], arr[1][i]);
			result=Math.max(tmp, result);
		}
		
		//출력
		System.out.println(result);
	
	}
}
