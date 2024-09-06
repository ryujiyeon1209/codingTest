import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//map정보 입력받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			char[] charr = sc.next().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = charr[j]-'0';
			}
		}
		
		
		//dp
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				
				//0일 때
				if(0==map[i][j]) continue;	
				else if(0==map[i-1][j-1]) continue;
				
				//1보다 크다면
				map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1]))+1;
			}
		}
		
		//한 변의 길이 최대값 
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				answer = Math.max(answer, map[i][j]);
			}
		}
		
		//출력
		System.out.println(answer*answer);
	}
}
