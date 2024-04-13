import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//원하는 막대기 길이 입력받기
		int x = sc.nextInt();
		
		if(x==64) {
			System.out.println(1);
			return;
		}
		
		//막대기 붙이기
		List<Integer> list =new ArrayList();
		
		//이분 탐색
		int min = 0;
		int max = 64;
		
		int sum = 0;
		while(min<max) {
			int mid = (min+max)/2;

			if(sum==x) break;
			
			else if(x<sum+(mid-min)) max = mid;
			else if(sum+(mid-min)<=x) {
				list.add(mid-min);
				sum+=(mid-min);
				min = mid;
			}
		}
		
		//출력
		System.out.println(list.size());
	}
}
