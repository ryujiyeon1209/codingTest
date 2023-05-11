import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//오목 배열 생성 및 값 입력받기
		int[][] arr = new int[21][21];
		for(int i=1; i<20; i++) {
			for(int j=1; j<20; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int winner=0;
		int r = 0;
		int c = 0;
		
		//0,0부터 배열 값이 0이 아니면 탐색 시작
		Outer:
		for(int i=1; i<20; i++) {
			for(int j=1; j<20; j++) {
				if(arr[i][j]!=0) {
					
					//사방탐색 시작 1. 오른쪽
					if(j+5<21 && arr[i][j]!=arr[i][j+5] && arr[i][j]!=arr[i][j-1] ) {
						int count=0;
						for(int k=1; k<5; k++) {
							if(arr[i][j]==arr[i][j+k]) count++;
						}
						
						if(count==4) {
							winner=arr[i][j]; 
							r=i; c=j; 
							break Outer; 
						} 
					} 
					
					//사방탐색 시작 2. 오른쪽 아래
					if(i+5<21 && j+5<21 && arr[i][j]!=arr[i+5][j+5] && arr[i][j]!=arr[i-1][j-1]) {
						int count=0;
						for(int k=1; k<5; k++) {
							if(arr[i][j]==arr[i+k][j+k]) count++;
						}
						
						if(count==4) {
							winner=arr[i][j]; 
							r=i; c=j; 
							break Outer; 
						} 
					}
					
					//사방탐색 시작 3. 아래
					if(i+5<21 && arr[i][j]!=arr[i+5][j] && arr[i][j]!=arr[i-1][j]) {
						int count=0;
						for(int k=1; k<5; k++) {
							if(arr[i][j]==arr[i+k][j]) count++;
						}
						
						if(count==4) {
							winner=arr[i][j]; 
							r=i; c=j; 
							break Outer; 
						} 
					}
					
					//사방탐색 시작 4. 아래 왼쪽
					if(i+5<21 && j-5>=0 && arr[i][j]!=arr[i+5][j-5] && arr[i][j]!=arr[i-1][j+1]) {
						int count=0;
						for(int k=1; k<5; k++) {
							if(arr[i][j]==arr[i+k][j-k]) count++;
						}
						
						if(count==4) {
							winner=arr[i][j]; 
							r=i+4; c=j-4; 
							break Outer; 
						} 
					}
				}
			}
		}
		
		//출력
		System.out.println(winner);
		if(winner!=0) System.out.println(r+ " " + c);
		
	}
}
