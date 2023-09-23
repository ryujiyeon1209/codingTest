import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		System.out.println(pow(a, b, c));
	}
	
	
	public static long pow(long a, long b, long c) {
		
		if(b==0) return 1;	//지수가 0일 경우 1 리턴
		
		long temp = pow(a, b/2, c);
		
		if(b%2==0) return (temp*temp)%c;
		else return ((temp*temp)%c)*a%c;
	}
}
