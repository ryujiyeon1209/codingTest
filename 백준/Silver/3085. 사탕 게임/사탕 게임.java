import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기 입력받기
		int n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		char[][] arr= new char[n][n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.next().toCharArray();
		}
		
		check(arr);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {				

				//행 글자 바꾸기
				if(arr[i][j]!=arr[i][j+1]) {
					char ch1=arr[i][j];
					char ch2=arr[i][j+1];
					
					arr[i][j]=ch2;
					arr[i][j+1]=ch1;
					
					check(arr);
					
					//원래 배열로 돌려놓기
					arr[i][j]=ch1;
					arr[i][j+1]=ch2;
				}
				
				//열 글자 바꾸기
				if(arr[j][i]!=arr[j+1][i]) {
					char ch1=arr[j][i];
					char ch2=arr[j+1][i];
					
					arr[j][i]=ch2;
					arr[j+1][i]=ch1;
					
					check(arr);
					
					//원래 배열로 돌려놓기
					arr[j][i]=ch1;
					arr[j+1][i]=ch2;
				}
			}
		}
		
		//출력
		System.out.println(max);
	}
	
	
	//최대값 구하기
	public static void check(char[][] arr) {
		
		//행 확인하기
		for(int i=0; i<arr.length; i++) {
			int count=1;
			for(int j=0; j<arr.length-1; j++) {
				if(arr[i][j]==arr[i][j+1]) count++;
				else {
					max=Math.max(max, count);
					count=1;
				}
			}
			max=Math.max(max, count);
		}
		
		//열 확인하기
		for(int i=0; i<arr.length; i++) {
			int count=1;
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j][i]==arr[j+1][i]) count++;
				else {
					max=Math.max(max, count);
					count=1;
				}
			}
			max=Math.max(max, count);
		}
	}

}
