import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//카약 정보 입력받기
		char[][] map = new char[n][m];
		for(int i=0; i<n; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		int[][] isvisited = new int[2][m];	//이 칸에 카약이 존재했는지
		int[] arr = new int[n+1];			//각 카약이 몇 번 칸에 존재하는지
		
		//카약 위치 찾기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(Character.isDigit(map[i][j])) {
					arr[map[i][j]-'0'] = j;
					isvisited[0][j]+=1;
					break;
				} 
			}
		}
		
		//등수 계산하기
		int sum = 0;
		for(int i=m-1; i>=0; i--) {
			if(0<isvisited[0][i]) sum++;
			isvisited[1][i] = sum;
		}
		
		//각 카약의 등수 확인하기
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			if(arr[i]==0) continue;
			sb.append(isvisited[1][arr[i]] + "\n");
			
		}
		
		//출력
		System.out.println(sb.toString());
		
	}
}
