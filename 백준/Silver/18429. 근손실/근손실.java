import java.util.*;

public class Main {
	
	static int n, k, count;
	static int[] arr, isselected;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//키드를 사용하는 날의 수
		n=sc.nextInt();
		
		//하루에 줄어드는 중량의 크기
		k=sc.nextInt();
		
		arr=new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//방문 체크, 순열 배열
		isvisited = new boolean[n];
		isselected = new int[n];
		
		count=0;
		Solution(0);
		
		//출력
		System.out.println(count);
	}
	
	
	//모든 경우의 수 > 순서 적용O > 순열
	public static void Solution(int idx) {
		
		if(n<=idx) {
			
			int strong = 500;
			for(int i=0; i<isselected.length; i++) {
				strong+=isselected[i];
				strong-=k;
				
				if(strong<500) return;
			}
			
			if(500<=strong) count++;
			return;
		}
		
		
		for(int i=0; i<arr.length; i++) {
			if(isvisited[i]) continue;
			
			isvisited[i]=true;
			isselected[i]=arr[idx];
			Solution(idx+1);
			
			isvisited[i]=false;
		}
	}
}
