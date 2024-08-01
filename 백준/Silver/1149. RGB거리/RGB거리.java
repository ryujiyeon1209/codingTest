import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
        //dp
		int[][] map = new int[n][3];
		for(int i=0; i<n; i++) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			
			map[i][0]=r;
			map[i][1]=g;
			map[i][2]=b;
		}
		
        //누적합
		for(int i=1; i<n; i++) {
			map[i][0]+=Math.min(map[i-1][1], map[i-1][2]);
			map[i][1]+=Math.min(map[i-1][0], map[i-1][2]);
			map[i][2]+=Math.min(map[i-1][0], map[i-1][1]);
		}
		
        //출력
		int min = Math.min(map[n-1][0], Math.min(map[n-1][1], map[n-1][2]));
		System.out.println(min);
	
	}
}
