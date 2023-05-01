import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int e = sc.nextInt();	//지구
		int s = sc.nextInt();	//태양
		int m = sc.nextInt();	//달
		
		//초기화
		int i=0; int j=0; int k=0;
		
		int count=0;
		while(true) {	
			
			i++; j++; k++;		
			
			//범위를 초과하면 0으로 초기화
			if(i>15) i=1;		
			if(j>28) j=1;
			if(k>19) k=1;

			count++;
			if(i==e && j==s && k==m) break;
		}
		
		//출력
		System.out.println(count);
		
	}
}
