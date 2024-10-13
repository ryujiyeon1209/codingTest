import java.util.*;

public class Main {
	
	static boolean[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		arr = new boolean[1001];
		solution(1000);
		
		int answer = 0;
		for(int i=0; i<test; i++) {
			int num = sc.nextInt();
			if(!arr[num]) answer++;
		}
		
		System.out.println(answer);
	}
	
	//소수 찾기
	public static void solution(int n) {
		
		arr[0]=true;
		arr[1]=true;
		
		for(int i=2; i<=(int)Math.sqrt(n); i++) {
			if(arr[i]) continue;
			for(int j=i*i; j<=n; j+=i) {
				arr[j]=true;
			}
		}
	}
}
