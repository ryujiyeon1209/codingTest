import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//참외 개수		
		int num=sc.nextInt();
		
		//방향 값 입력받기
		int[][] arr = new int[6][2];
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				int info= sc.nextInt();
				arr[i][j]=info;
			}			
		}
		
		
		//가장 긴 가로, 세로 구하기
		int idx_r=0;
		int idx_c=0;
		int max_r=0;
		int max_c=0;
		for(int i=0; i<arr.length; i++) {
			//1, 2면 가로
			if(arr[i][0]==1 || arr[i][0]==2) {
				if(arr[i][1]>max_r) { 
					max_r = arr[i][1]; 
					idx_r=i;
				}				
			}
			
			//3, 4면 세로
			if(arr[i][0]==3 || arr[i][0]==4) {
				if(arr[i][1]>max_c) { 
					max_c = arr[i][1];
					idx_c=i;
				}		
			}
		}
		
		
		int c=0;
		int r=0;
		
		//작은 세로 구하기
		if(idx_r==0) c = Math.abs(arr[5][1]-arr[1][1]);
		else if(idx_r==5) c = Math.abs(arr[4][1]-arr[0][1]);
		else c = Math.abs(arr[idx_r-1][1]-arr[idx_r+1][1]);
		
		//작은 가로 구하기
		if(idx_c==0) r = Math.abs(arr[5][1]-arr[1][1]);
		else if(idx_c==5) r = Math.abs(arr[4][1]-arr[0][1]);
		else r = Math.abs(arr[idx_c-1][1]-arr[idx_c+1][1]);
		
		
		//면적 구하기 > 큰 면적 - 작은 면적
		int result = (max_r*max_c) - (r*c);
		System.out.println(result * num);
	}	//main 끝 
}
