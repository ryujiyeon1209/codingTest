import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[8][8];
		
		String king = sc.next();
		String stone = sc.next();
		
		//킹과 돌 자리 표시하기
		int kingr = 7-(king.charAt(1)-'1');
		int kingc = king.charAt(0)-'A';
		map[kingr][kingc] = 10;
		
		int stoner = 7-(stone.charAt(1)-'1');
		int stonec = stone.charAt(0)-'A';
		map[stoner][stonec] = -1;
		
		int[] r = {0, 0, 1, -1, -1, -1, 1, 1};
		int[] c = {1, -1, 0, 0, 1, -1, 1, -1};
		
		//이동하기
		int test = sc.nextInt();
		for(int t=0; t<test; t++) {
			String command = sc.next();
			
			int idx = check(command);
			int dr = kingr+r[idx];
			int dc = kingc+c[idx];
			
			if(!(0<=dr && dr<8 && 0<=dc && dc<8)) continue;
			else if(dr==stoner && dc==stonec) {
				if(!(0<=stoner+r[idx] && stoner+r[idx]<8 && 0<=stonec+c[idx] && stonec+c[idx]<8)) continue;
				stoner+=r[idx];
				stonec+=c[idx];
			}
			
			kingr=dr;
			kingc=dc;
		}
		
		//출력
		king = ((char)(kingc+65))+String.valueOf(8-kingr);
		stone = ((char)(stonec+65))+String.valueOf(8-stoner);
		
		System.out.println(king);
		System.out.println(stone);
	}
	
	public static int check(String str) {
		if(str.equals("R")) return 0;
		if(str.equals("L")) return 1;
		if(str.equals("B")) return 2;
		if(str.equals("T")) return 3;
		if(str.equals("RT")) return 4;
		if(str.equals("LT")) return 5;
		if(str.equals("RB")) return 6;
		return 7;
	}
}
