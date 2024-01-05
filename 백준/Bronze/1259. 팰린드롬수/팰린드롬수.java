import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.next();
			if(str.equals("0")) break;
			
			char[] chArr = str.toCharArray();
			
			boolean flag = true;
			for(int i=0; i<chArr.length/2; i++) {
				if(chArr[i]!=chArr[chArr.length-1-i]) flag = false;
			}
		
			if(flag) System.out.println("yes");
			else System.out.println("no");

		}
	}
}
