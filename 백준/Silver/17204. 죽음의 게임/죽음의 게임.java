import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		int answer=0;
		boolean[] isvisited = new boolean[n];
		
		int idx = 0;
		while(idx!=m) {
			if(isvisited[idx]) { answer = -1; break; }	//이미 방문한 노드라면, 반복문 종료
			
			answer++;
			isvisited[idx] = true;
			idx=arr[idx];
		}
		
        //출력
		System.out.println(answer);

	}
}
