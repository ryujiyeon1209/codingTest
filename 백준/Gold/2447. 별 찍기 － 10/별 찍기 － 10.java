import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static char[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		int n = sc.nextInt();
		
		//배열 생성
		arr = new char[n][n];
		
		Solution(0, 0, n, false);
		
		//StringBuilder에 배열 담기
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		//출력
		System.out.println(sb.toString());
	}
	
	
	//재귀
	public static void Solution(int x, int y, int n, boolean blank) {
		
		//현재 칸이 공백일 때
		if(blank) {
			for(int i=x; i<x+n; i++) {
				for(int j=y; j<y+n; j++) {
					arr[i][j]=' ';
				}
			}
			return;
		}
		
		
		//더이상 쪼갤 수 없을 때
		if(n==1) {
			arr[x][y]='*';
			return;
		}
	
	
		int size=n/3;	//배열 크기 3등분해주기
		int count=0;
		for(int i=x; i<x+n; i+=size) {
			for(int j=y; j<y+n; j+=size) {
				count++;
				
				if(count==5) Solution(i, j, size, true);	//가운데
				else Solution(i, j, size, false);		//가운데가 아닐 때		
			}
		}
	}
}
