import java.util.Scanner;

public class Main {
	
	static char[][] map;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		map = new char[h][w];
		for(int i=0; i<h; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		min = Integer.MAX_VALUE;
		
		//0,0부터 시작
		for(int i=0; i+8<=h; i++){
			for(int j=0; j+8<=w ; j++){
				min = isMin(i, j);
			}
		}
		
		//출력
		System.out.println(min);
		
	}
	
	
	public static int isMin(int hn, int wn) {
		
		char[] bw = {'B', 'W'};
		int point=0;
		
		for(int t=0; t<bw.length; t++) {	
			
			int count = 0;
			for(int i=hn; i<hn+8; i++) {
				for(int j=wn; j<wn+8; j++) {
					if(map[i][j]!=bw[(t+point++)%2]) count++; 
				}
				point++;	//B 아랫줄에는 W여야하기 때문에 point 한 번 건너뛰기
			}
			
			min = Math.min(min, count);
		}
		
		return min;
	}
}
