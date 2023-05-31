import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, count;
	static long result, max, min;
	static String answerMax, answerMin;
	static int[] num, choose;
	static String[] sign;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//부등호 개수
		n = sc.nextInt();
		
		//부등호 배열
		sign = new String[n];
		for(int i=0; i<n; i++) {
			sign[i]=sc.next();
		}
		
		//1-9 숫자 배열
		num = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		choose = new int[10];
		
		isvisited = new boolean[10];

		//최소값 최대값 초기화도 long타입으로 해주기
		max=Long.MIN_VALUE;
		min=Long.MAX_VALUE;
		Solution(0);
		
		System.out.println(answerMax);
		System.out.println(answerMin);

	}
	
	//n개중에 n개 고르기 > 순서 영향O > 순열
	public static void Solution(int idx) {
		
		
		if(idx>=10) {
			
			//숫자 10개중에 부등호 개수 +1개만 str에 넣기
			String str="";
			for(int i=0; i<n+1; i++) { str+=choose[i]; }
			
			//부등호에 맞는지 확인하기
			Boolean flag=true;
			
			for(int i=0; i<n; i++) {
				if(sign[i].equals(">")) { 
					if(!(choose[i]>choose[i+1])) { flag=false; break;}
				} else {
					if(!(choose[i]<choose[i+1])) { flag=false; break;}
				}
			}
			
			//최소값 최대값 비교
			if(flag) {
				result=Long.parseLong(str);

				if(result>max) { max=result; answerMax=str;}
				if(result<min) { min=result; answerMin=str;}
			}
			return;
		}
		
        
		//순열 코드
		for(int i=0; i<10; i++) {
			if(isvisited[i]) continue;
			
			isvisited[i]=true;
			choose[idx]=num[i];
			Solution(idx+1);
			
			isvisited[i]=false;
			
		}
	}
}
