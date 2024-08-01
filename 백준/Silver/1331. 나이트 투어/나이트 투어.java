import java.util.*;

public class Main {
	
	static String answer;
	static boolean[][] isvisited;
	static String[] command;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		isvisited = new boolean[7][7];
		
		//체스 움직임 배열
		command = new String[37];
		for(int i=0; i<36; i++) {
			command[i] = sc.next();
		}
		
		//처음으로 돌아가기
		command[36]=command[0];
		
		answer = "Valid";
		DFS(0);
		
		//출력
		System.out.println(answer);
	}
	
	//DFS
	public static void DFS(int idx) {
		
		if(36<=idx) return;
		
		String cur = command[idx];
		String next = command[idx+1];
		
		int r = cur.charAt(0)-'A';
		int c = cur.charAt(1)-'0';
		
		//조건 1 : 현재 위치가 처음 도착한 위치인지
		if(isvisited[r][c]) {
			answer="Invalid";
			return;
		}
		
		//조건 2 : 다음 위치로 이동 시 가능한 이동인지
		int dr = next.charAt(0)-'A';
		int dc = next.charAt(1)-'0';
		
		if((Math.abs(dr-r)==2 && Math.abs(dc-c)==1) ||
				(Math.abs(dr-r)==1 && Math.abs(dc-c)==2)) {
			isvisited[r][c]=true;
			DFS(idx+1);
		}
		else {
			answer="Invalid";
			return;
		}		
	}
}
