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
		
		//결과
		int count=0;
		
		//투포인터
		int lt=0;
		int sum=0;
		
		for(int rt=0; rt<n; rt++) {
			sum+=arr[rt];

			if(sum==m)  count++;
			while(sum>=m) {	//크거나 같다면 sum의 값이 m보다 작을 때까지 빼주기
				sum-=arr[lt++];
				if(sum==m) count++;
			}	
		}
		
		//출력
		System.out.println(count);
	}
}
