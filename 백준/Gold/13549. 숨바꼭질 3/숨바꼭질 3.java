import java.util.*;

public class Main {
	
	static int answer;
	static int[] isvisited;
	static int[] dir;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer = Integer.MAX_VALUE;
		
		int n = sc.nextInt();			//수빈
		int m = sc.nextInt();			//동생
		
		dir = new int[] {2, 1, -1};
		isvisited = new int[100002];
		for(int i=0; i<isvisited.length; i++) {
			isvisited[i] = Integer.MAX_VALUE;
		}
		
		if(n>m) answer = n-m;			//수빈이 동생보다 위치가 크다면
		else BFS(n, m);
		
		System.out.println(answer);
		
	}
	
	public static void BFS(int n, int m) {
		Queue<int[]> queue = new LinkedList();
		
		isvisited[n]=0;
		queue.add(new int[] {n, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int i = cur[0];
			int time = cur[1];
			
			if(i==m) {
				answer = time;
			}
			
			for(int k=0; k<3; k++) {
				int move = (k==0) ? dir[k]*i : dir[k]+i;
				int mtime = (k==0) ? time : time+1;

				if(move<0 || isvisited.length<=move) continue;
				if(isvisited[move]<=mtime) continue;

				isvisited[move]=mtime;
				queue.add(new int[] {move, mtime});
				
			}
		}	
	}
}

//System.out.println("move : " +move+ ", mtime : " +mtime); 
//System.out.println("i : " +i+ " > time : " +time);