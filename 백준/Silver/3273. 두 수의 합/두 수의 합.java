import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, m, end, count;
	static int[] arr, choose;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//숫자 개수 입력받기
		n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//더해서 나와야 하는 숫자
		m = sc.nextInt();
		
		Arrays.sort(arr);
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i]+arr[j]==m) { count++; break;}
			}
		}
		
		//출력
		System.out.println(count);

	}
}
