import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] arr = new char[N];
		String str = sc.next();
		char[] alpa = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = str.charAt(i);
		}
		for(int i=0; i<N; i++) {
			for(int j=1; j<alpa.length; j++) {
				if(arr[i] == alpa[j]) {
					sum += j * Math.pow(31, i);
				}
			}
		}
		System.out.println(sum);
	}
}