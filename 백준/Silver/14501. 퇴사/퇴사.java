import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, money, pay;
	static int[][] work;
	static boolean[] isvisited, isWork;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//퇴사까지 남은 날
		n = sc.nextInt();
	
		//상담 배열 생성 및 값 입력받기
		work = new int[n+1][2];
		for(int i=1; i<=n; i++) {
			work[i][0]=sc.nextInt();	//상담 시간
			work[i][1]=sc.nextInt();	//금액
		}
		
		isvisited=new boolean[n+1];
		
		pay=0;
		Solution(0);
		
		//출력
		System.out.println(pay);
	}
	
	public static void Solution(int idx) {
		
		if(idx==n+1) {
			money=0;
			isWork=new boolean[n+1];
			
			for(int i=1; i<=n; i++) {
				if(isvisited[i]) {

					if(i+work[i][0]>n+1) {continue;}
					
					boolean flag=true;
					for(int j=i; j<i+work[i][0]; j++) { 
						if(isWork[j]) { flag=false; break;}
					}
					
					if(flag) {
						money+=work[i][1];
						for(int j=i; j<i+work[i][0]; j++) { isWork[j]= true; }
					}
				}
			}
			
			if(pay<money) { pay=money; }
			return;
		}
		
		isvisited[idx]=true;
		Solution(idx+1);
		
		isvisited[idx]=false;
		Solution(idx+1);
	}
}
