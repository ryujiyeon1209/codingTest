import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, count, min, max;
	static int[] arr;
	static char[] operator, choose;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//수의 개수
		int n = sc.nextInt();
		
		//숫자 배열 생성 및 값 입력받기
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//연산자 개수
		count=0;
		
		//연산자 배열 생성 및 값 입력받기
		int[] tmp = new int[4];
		for(int i=0; i<4; i++) {
			tmp[i]=sc.nextInt();
			
			count+=tmp[i];
		}
		
		//연산자 배열 생성
		int idx=0;
		operator = new char[count];
			
		//+연산자
		for(int i=0; i<tmp[0]; i++) {
			operator[idx++] = '+'; 
		}
		
		//-연산자
		for(int i=0; i<tmp[1]; i++) {
			operator[idx++] = '-'; 
		}
		
		//*연산자
		for(int i=0; i<tmp[2]; i++) {
			operator[idx++] = '*'; 
		}
		
		//%연산자
		for(int i=0; i<tmp[3]; i++) {
			operator[idx++] = '/'; 
		}
		
		//방문 체크 배열
		isvisited = new boolean[count];
		
		//고른 연산자
		choose = new char[count];

		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		Solution(0);
		
		//출력
		System.out.println(max);
		System.out.println(min);
		
	}
	
	//n개 중에 m개 고르기 > 순서 영향 > 순열
	public static void Solution(int idx) {
		
		if(idx==count) {
			int index=1;		//arr인덱스
			int sum=arr[0];		//연산 결과
			
			for(int i=0; i<count; i++) {
				if(choose[i]=='+')
					sum+=arr[index++];
				else if(choose[i]=='-')
					sum-=arr[index++];
				else if(choose[i]=='*')
					sum*=arr[index++];
				else if(choose[i]=='/')
					sum/=arr[index++];
			}
			
			min=Math.min(sum, min);
			max=Math.max(sum, max);
			return;
		}
		
		
		for(int i=0; i<count; i++) {
			if(isvisited[i]) continue;

			choose[idx]=operator[i];
			isvisited[i]=true;
			Solution(idx+1);
			
			isvisited[i]=false;
		}
	}
}
