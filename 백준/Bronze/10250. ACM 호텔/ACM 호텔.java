import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=0; t<test; t++) {
			int h = sc.nextInt(); 	//1
			int w = sc.nextInt();	//13
			int n = sc.nextInt();	//11	
			
			int sh = 0;
			if(h!=1 && n%h==0) sh = h;
			else if(h==1 && n%h==0) sh = 1;
			else sh = n%h;
			
			int sw = 0;
			if(n%h==0) sw = n/h;
			else sw = (n/h)+1;
			
			if(sw<10) System.out.println(sh + "0" + sw);
			else System.out.println(sh + ""+ sw);
			
			
		}
	}
}
