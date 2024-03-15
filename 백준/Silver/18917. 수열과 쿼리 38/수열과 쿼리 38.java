import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long sum = 0;
		long xor = 0;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int type = sc.nextInt();
			
			if(type==1) {
				long num = sc.nextLong();
				
				sum+=num;
				xor = xor^num;
			}
			
			else if(type==2) {
				long num = sc.nextLong();
				
				sum-=num;
				xor = xor^num;
			}
			
			else if(type==3) {
				sb.append(sum+"\n");
			}
			
			else if(type==4) {
				sb.append(xor+"\n");
			}
		}
		
		//출력
		System.out.println(sb.toString());
	}
}
