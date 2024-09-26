import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		
		for(int t=0; t<test; t++) {
			
			//출발 지점
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			
			//도착 지점
			int ex = sc.nextInt();
			int ey = sc.nextInt();
			
			//진입 이탈 횟수
			int answer = 0;
			
			//행성의 개수
			int n = sc.nextInt();
			for(int i=0; i<n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int r = sc.nextInt();
				
				//행성 중심과 지점의 거리
				boolean sdis = check(x, y, sx, sy, r);
				boolean edis = check(x, y, ex, ey, r);
				
				if(sdis!=edis) answer++;
			}
			
			//출력
			System.out.println(answer);
			
		}
	}
	
	//행성 중심과 지점의 거리가 반지름보다 짧은지 확인
	public static boolean check(int x, int y, int sx, int sy, int r) {
		return (int)Math.pow(x-sx, 2)+(int)Math.pow(y-sy, 2)<(int)Math.pow(r, 2);
	}
}
