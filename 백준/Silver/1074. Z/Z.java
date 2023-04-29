import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int count;
	static int[] r, c;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 값 입력받기
		int n = sc.nextInt();
		
		//2차원 배열 크기 구하기
		int totalSize = (int)Math.pow(2, n);
		
		//찾아야 하는 배열의 행, 열 값 입력받기
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		count=0;
		DFS(r, c, totalSize);
		
		//출력
		System.out.println(count);
	}
	
	
	public static void DFS(int r, int c, int size) {
		
		//배열의 크기가 1이면 정답 출력하고 재귀 멈추기
		if(size==1) { return; }
		
		//몇사분면에 있는지 확인하기
		if(0<=r && r<size/2 && 0<=c && c<size/2) count+=0;
		else if(0<=r && r<size/2 && size/2<=c && c<size) {
			count+=(size*size)/4;
			c = c-(size/2);
		}
		else if(size/2 <=r && r<size && 0<=c && c<size/2) {
			count+=((size*size)/4)*2;
			r = r-(size/2);
		}
		else if(size/2 <=r && r<size && size/2<=c && c<size) {
			count+=((size*size)/4)*3;
			r = r-(size/2);
			c = c-(size/2);
		}
	
		//재귀 실행
		size=size/2;
		DFS(r, c, size);
	}
}
