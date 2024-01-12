import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		//땅의 높이 입력받고, 최소값 최대값 구하기
		int[][] map = new int[h][w];
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(max<map[i][j]) max = map[i][j];
				if(map[i][j]<min) min = map[i][j];
			}
		}
		
		int answer = 0;
		int answerTime = Integer.MAX_VALUE;
		
		//완전탐색 min부터 max까지

		for(int c=min; c<=max; c++) {
			
			int time = 0;
			int bag = b;

			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
				
					//현재 좌표의 높이가 t보다 낮으며, 인벤토리에 블록이 있을 때
					if(map[i][j]<c) {
						bag-=(c-map[i][j]);
						time+=(c-map[i][j]);
					}
					
					//현재 좌표의 높이가 t보다 높을 때
					else if(c<=map[i][j]) {
						bag+=(map[i][j]-c);
						time+=(2*(map[i][j]-c));
					}
							
				}
			}
			
			if(bag<0) break;
			
			if(time<=answerTime && answer<=c) {
				answer = c;
				answerTime = time;
			}
			
		}
		
		//출력
		System.out.println(answerTime +" "+ answer);
		
	}
}