import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//학생 수 입력받기
		int n = sc.nextInt();
		
		//반 입력받기
		int[][] map = new int[n][5];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//비교하기
		boolean[][] friend = new boolean[n][n];
		for(int k=0; k<map.length; k++) {				//학생
			for(int i=0; i<map[k].length; i++) {		//학년
				for(int j=k+1; j<map.length; j++) {	 //비교 학생
					if(map[j][i]==map[k][i]) {
						friend[k][j]=true;
						friend[j][k]=true;
					}
				}
			}
		}
		
		//가장 큰 값
		int max = 0;
		int answer = 0;
		for(int i=0; i<friend.length; i++) {
			int sum = 0;
			for(int j=0; j<friend.length; j++) {
				if(friend[i][j]) sum++;
			}
			
			if(max<sum) {
				max = sum;
				answer = i;
			}
		}
		
		//출력
		System.out.println(answer+1);

	}
}
