import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = rev(sc.next());
		int y = rev(sc.next());
		
		int answer = rev(String.valueOf(x+y));
		
		//출력
		System.out.println(answer);
		
	}
	
	//순서 바꾸는 메서드
	public static int rev(String x) {
		
		char[] chArr = x.toCharArray();
		
		String result = "";
		for(int i=chArr.length-1; i>=0; i--) {
			result+=chArr[i];
		}
		
		return Integer.parseInt(result);
	}
}
