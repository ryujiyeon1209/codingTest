import java.util.Scanner;

public class Main {
	
	static int white, blue;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		int n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		white=0;
		blue=0;		
		check(0, 0, n);
		
		
		//출력
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	
	//같은 색인지 확인하기
	public static void check(int r, int c, int length) {
		
		if(length<1) return;
		
		int start = arr[r][c];
		
		boolean flag=true;
		for(int i=r; i<r+length; i++) {
			for(int j=c; j<c+length; j++) {
				if(arr[i][j]!=start) { flag=false; break;}
			}
		}
		
		//다른 색이면 길이를 /2해서 탐색
		if(!flag) {
			length=length/2;
			
			check(r, c, length);
			check(r, c+length, length);
			check(r+length, c, length);
			check(r+length, c+length, length);	
		
		//같은 색이면 하얀색인지 파란색인지 구분
		} else {
			if(start==0) white++;
			else blue++;
		}
	}
}
