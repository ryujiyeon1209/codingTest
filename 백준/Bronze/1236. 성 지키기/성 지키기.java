import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//성 정보 입력받기
		char[][] map = new char[n][m];
		for(int i=0; i<n; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		//경비병 존재하는지 확인하는 배열
		boolean[] r = new boolean[n];
		boolean[] c = new boolean[m];
		
		//경비원이 지키고 있는 행열 표시
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]=='X') {
					r[i] = true;
					c[j] = true;
				}
			}
		}
		
		//새로운 경비병 세우기
		int answer=0;
		for(int i=0; i<r.length; i++) {
			if(r[i]) continue;
			
			for(int j=0; j<c.length; j++) {
				if(!c[j]) {
					r[i] = true;
					c[j] = true;
					answer++;
					break;
				}
			}
		}
		
		//세우지 못한 경비병 있나 확인하기
		for(int i=0; i<r.length; i++) {
			if(!r[i]) answer++;
		}
		
		for(int i=0; i<c.length; i++) {
			if(!c[i]) answer++;
		}
		
		
		//출력
		System.out.println(answer);
	}
}
