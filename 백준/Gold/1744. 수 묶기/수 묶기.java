import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//수 개수 입력받기
		int n = sc.nextInt();
	
		//배열 생성 및 값 입력받기
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}

		//배열 정렬
		Arrays.sort(arr);
		
		//방문체크 배열
		boolean[] isvisited = new boolean[n];

		int sum=0;
		
		//음수 먼저 수 묶기
		for(int i=0; i<arr.length-1; i++) {
			if(!isvisited[i] && !isvisited[i+1] && arr[i]<0 && arr[i+1]<=0) {
				sum+= arr[i]*arr[i+1];
				isvisited[i]=true; isvisited[i+1]=true;
			}
		}
		
		//큰 수 묶기
		for(int i=arr.length-1; i>=1; i--) {
			if(!isvisited[i] && !isvisited[i-1] && arr[i]>1 && arr[i-1]>1) {
				sum+=arr[i]*arr[i-1];
				isvisited[i]=true; isvisited[i-1]=true;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!isvisited[i]) sum+=arr[i];
		}
		
		//출력
		System.out.println(sum);
	}
}
