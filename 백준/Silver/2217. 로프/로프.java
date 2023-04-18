import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//로프의 개수
		int n = sc.nextInt();
		
		//각각의 로프가 버틸 수 있는 최대 중량을 담을 배열
		int[] arr = new int[n];
		
		//값 입력받기
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//오름차순으로 정렬하기
		Arrays.sort(arr);

		//로프 중에서 감당할 수 있는 최대 무게 
		int weight = arr[n-1];	
		
		//최대 중량부터 하나씩 줄여가면서 로프가 감당할 수 있는지 확인하기
		int max=0;
		for(int i=weight; i>=0; i--) {
			
			int result=0;
			for(int j=arr.length-1; j>=0; j--) {
				if(arr[j]<i) { break; }		//이번 로프가 견딜 수 없다면,
				else result+=i;				//이번 로프가 견딜 수 있다면, 무게에 더해준다.
			}
			
			max=Math.max(max, result);
		}
		
		//출력
		System.out.println(max);
	}
}
