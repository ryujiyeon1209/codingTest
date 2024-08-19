import java.util.*;

public class Main {
	
	static int m, count, answer;
	static boolean[] closet;
	static int[] use;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//옷장 수
		int n = sc.nextInt();
		
		//열려있는 옷장 번호
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		
		//사용할 옷장 체크
		m = sc.nextInt();
		use = new int[m];
		
		for(int i=0; i<m; i++) {
			use[i] = sc.nextInt();
		}
		
		//DFS
		answer = Integer.MAX_VALUE;
		DFS(d1, d2, 0, 0);
		
		//출력
		System.out.println(answer);
		
	}
	
	//DFS
	public static void DFS(int d1, int d2, int idx, int count) {
		
		if(m<=idx) {
			answer = Math.min(answer, count);
			return;
		}	
		
		//사용할 벽장과 열려있는 옷장 거리 차이
		int diff1 = Math.abs(d1-use[idx]);	
		int diff2 = Math.abs(d2-use[idx]);	
		
		//옷장 옮기기
		if(diff1<diff2) {
			count+=diff1;
			DFS(use[idx], d2, idx+1, count);
			
			count-=diff1;
			count+=diff2;
			DFS(d1, use[idx], idx+1, count);
		}
		
		else if(diff1>diff2) {
			count+=diff2;
			DFS(d1, use[idx], idx+1, count);
			
			count-=diff2;
			count+=diff1;
			DFS(use[idx], d2, idx+1, count);
		}
		
		else {
			count+=diff1;
			DFS(use[idx], d2, idx+1, count);
					
			DFS(d1, use[idx], idx+1, count);
		}
	}
}
