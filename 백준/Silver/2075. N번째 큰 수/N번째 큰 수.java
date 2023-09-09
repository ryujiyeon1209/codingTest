import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 및 값 입력받기
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		//비교할 index 저장할 배열
		int[] search = new int[n];
		for(int i=0; i<n; i++) {
			search[i]=n-1;
		}
		
		//n번째 최대값 찾기
		int max=0;
		for(int i=0; i<n; i++) {
			
			max=0;	//최대값 찾기
			for(int j=0; j<n; j++) {
				if(arr[search[j]][j] > arr[search[max]][max]) max=j;
			}
			if(i!=n-1) search[max]-=1;
		}
		
		//출력
		System.out.println(arr[search[max]][max]);
		
	}
}
