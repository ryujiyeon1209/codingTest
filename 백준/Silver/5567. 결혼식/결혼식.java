import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//친구 수 입력받기
		int n = sc.nextInt();
		
		//관계 수 입력받기
		int m = sc.nextInt();
		
		//관계배열 생성 및 초기화
		int[] p = new int[n+1];
		for(int i=0; i<p.length; i++) {
			p[i]=i;
		}
		
		//관계 입력받기
		int[][] conn = new int[m][2];
		for(int i=0; i<m; i++) {
			int f1 = conn[i][0] = sc.nextInt();
			int f2 = conn[i][1] = sc.nextInt();
			
			//친구인지 확인 > 1로 표시
			if(f1==1) p[f2]=1;
			else if(f2==1) p[f1]=1;		
		}
		
		//친구의 친구인지 확인 > 0으로 표시
		for(int i=0; i<m; i++) {
			int f1 = conn[i][0];
			int f2 = conn[i][1];
			
			if(p[f1]==1 && p[f2]!=1) p[f2]=0;
			else if(p[f2]==1 && p[f1]!=1) p[f1]=0;
		}
		
		//초대할 사람 수 세기
		int count=0;
		for(int i=2; i<p.length; i++) {
			if(p[i]==1 || p[i]==0) count++;
		}
		
		//출력
		System.out.println(count);
	}

}
