import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//방정식 배열 생성 및 값 입력받기
		int[][] equation = new int[2][3];
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				equation[i][j]=sc.nextInt();
			}
		}
		
		//완전탐색
		Outer:
		for(int x=-999; x<=999; x++) {
			for(int y=-999; y<=999; y++) {
				
				//첫번째 방정식 확인 
				if((equation[0][0]*x) + (equation[0][1]*y) == equation[0][2]) {
					
					//두번째 방정식 확인
					if((equation[1][0]*x) + (equation[1][1]*y) == equation[1][2]) { 
						System.out.println(x +" "+ y);
						break Outer;
					}
				}
			}
		}
		
	}
}
