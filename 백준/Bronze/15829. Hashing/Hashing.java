import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//알파벳 번호 배열 만들기
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		//문자 개수 입력받기
		int n = sc.nextInt();
		
		//문자열 입력받기 > 문자 배열로 만들기
		char[] test = sc.next().toCharArray();
		
		//해싱 함수 공식 적용하기
		long result=0;
		for(int i=0; i<test.length; i++) {
			for(int j=0; j<alphabet.length; j++) {
				if(alphabet[j]==test[i]) {
					result+=(((j+1)*Math.pow(31, i)));
				}
			}
		}
		
//		System.out.println(result);
		System.out.println(result%1234567891);
		
		
	}
}
