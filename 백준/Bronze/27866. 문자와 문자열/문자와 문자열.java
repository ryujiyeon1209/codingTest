import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int n = sc.nextInt()-1; 
		
		char[] charArr = str.toCharArray();
		System.out.println(charArr[n]);
		
	}
}
