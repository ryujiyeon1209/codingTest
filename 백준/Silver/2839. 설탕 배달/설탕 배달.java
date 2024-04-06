import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//설탕 무게
		int n = sc.nextInt();
		
		//봉지 개수
		int answer = 0;
		
		while(0<n) {
			
			//큰 봉지 사용할 수 있으면 사용하기
			if(n%5==0) {
				answer += (n/5);
				n = 0;
			}
			
			//큰 봉지가 안되면 작은 봉지 사용하기
			else if(3<=n) {	
				answer++;
				n-=3;
			}
			
			//큰 봉지, 작은 봉지 모두 사용이 불가하다면
			else if(n<3) {
				answer = -1;
				n = 0;
			}
		}
		
		//출력
		System.out.println(answer);
		
	}
}
