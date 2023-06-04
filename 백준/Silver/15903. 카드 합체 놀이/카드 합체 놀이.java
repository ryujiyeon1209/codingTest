import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//카드 개수
		int n = sc.nextInt();
		
		//합체 횟수
		int m = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		Long[] card = new Long[n];
		for(int i=0; i<n; i++) {
			card[i]=sc.nextLong();
		}
		
		//배열 정렬
		Arrays.sort(card);
		
		//배열 합 최소값 만들기
		for(int i=0; i<m; i++) {
			Long num=card[0]+card[1];
            
			card[0]=num;
			card[1]=num;
			
			Arrays.sort(card);
		}
		
		//배열 값 더하기
		Long sum= 0L;
		for(int i=0; i<n; i++) {
			sum+=card[i];
		}
		
		//출력
		System.out.println(sum);
	}
}
