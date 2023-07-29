import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//점수 배열 생성 및 값 입력받기
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		//정렬
		Arrays.sort(arr);
		
		//불만도 합 구하기
		long result=0;
		for(int i=0; i<arr.length; i++) {
			result += Math.abs(arr[i]-(i+1));
		}
		
		//출력
		System.out.println(result);
	}
}
