import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, s, sum, count;
	static int[] arr;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//숫자의 개수
		n = sc.nextInt();
		
		//더해서 나와야 하는 수
		s = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
	
		//방문체크 배열
		isvisited =new boolean[n];
		
		//부분집합 매서드 호출
		count=0;
		Solution(0);
		
		//출력 > s가 0이면, 모두 선택하지 않았을 때도 count++가 된다
		if(s==0) count--;
		System.out.println(count);
	}
	
	public static void Solution(int idx) {
		
		//끝까지 탐색했으면 재귀 종료
		if(idx==n) {
			sum=0;
			for(int i=0; i<isvisited.length; i++) {
				if(isvisited[i]) sum+=arr[i];
			}

			if(sum==s) count++; 
			return;
		}
		
		//부분집합
		if(!isvisited[idx]) {
			isvisited[idx]=true;
			Solution(idx+1);
			
			isvisited[idx]=false;
			Solution(idx+1);
		}	
	}
}
