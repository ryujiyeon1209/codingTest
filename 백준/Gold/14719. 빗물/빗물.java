import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		
		int height = sc.nextInt();	//높이
		int width = sc.nextInt();	//너비
		
		//벽돌 입력받기
		boolean[][] arr = new boolean[height][width];
		for(int i=0; i<width; i++) {		
			int rain = sc.nextInt();
			for(int j=0; j<rain; j++) {
				arr[j][i]=true;
			}
		}
				
		int rain=0;	//최종 빗물의 양
		
		for(int i=0; i<height; i++) {	
			
			int tmp=0;			//임시 빗물의 양
			boolean flag=false;	//벽돌인지 확인
			
			for(int j=0; j<width; j++) {
				
				//그 전에 벽돌이 없었는데 지금 좌표가 벽돌일 때
				if(arr[i][j] && !flag) flag=true;
				
				//그 전에 벽돌이 있었는데 지금 벽돌이 아닐 때
				else if(!arr[i][j] && flag) tmp++;
				
				//그 전에 벽돌이 있었으면서 현재 좌표도 벽돌일 때
				else if(arr[i][j] && flag) {
					rain+=tmp;
					tmp=0;
				}	
			}
		}
		
		//출력
		System.out.println(rain);
		
	}
}
