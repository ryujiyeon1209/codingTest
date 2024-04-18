import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//시험장 개수
		int n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//총 감독관이 감시할 수 있는 응시생 수
		int total = sc.nextInt();
		
		//부 감독관이 감시할 수 있는 응시생 수
		int sub = sc.nextInt();
		
		//총 감독관 1명은 기본 값
		long count=n;	
		
		for(int i=0; i<n; i++) {
			
			//부 감독관이 감시해야 할 응시생 수
			double subTaker = (arr[i]*1.0)-total;
			
			
			if(subTaker<=0) continue;		//총 감독관으로 충분하면
			count+=Math.ceil(subTaker/sub);	//부 감독관이 필요하면	
		}
		
		//출력
		System.out.println(count);
		
	}
}
