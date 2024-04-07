import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Long idx = n+1L;	//기준 값
		Long count = 1L;	//횟수
		Long answer = 0L;	//누적 합
		
		while(count<n) {
			answer+=(idx*count);	//몫과 나머지가 count인 수를 answer에 더하기
			count++;
		}
		
		//출력
		System.out.println(answer);
	}
}

