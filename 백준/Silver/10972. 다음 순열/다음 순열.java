import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		//배열
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//메서드 실행
		boolean flag = Solution();
		
		if(!flag) System.out.println(-1);
		else {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
	
	public static boolean Solution() {

		//내림차순 길이 구하기
		int i=arr.length-1;
		while(0<i && arr[i]<=arr[i-1]) {
			i--;
		}
		
		//내림차순이면 flase
		if(i==0) return false;
		
		//바꿀 숫자 구하기
		int j=arr.length-1;
		while(0<j && arr[j]<=arr[i-1]) {
			j--;
		}
		
		swap(i-1, j);
		
		//순열 뒤집기
		j=arr.length-1;
		while(i<j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}
	
	
	public static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
