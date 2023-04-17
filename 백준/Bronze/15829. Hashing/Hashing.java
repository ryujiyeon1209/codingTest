import java.util.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//알파벳 번호 배열 만들기
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		//알파벳 번호 배열 맵으로 바꾸기
		Map<Character, Integer> map = new HashMap();
		for(int i=0; i<alphabet.length; i++) {
			map.put(alphabet[i], (i+1));
		}
		
		
		//문자 개수 입력받기
		int n = sc.nextInt();
		
		//문자열 입력받기 > 문자 배열로 만들기
		char[] test = sc.next().toCharArray();
		
		//해싱 함수 공식 적용하기
		long result=0;
		for(int i=0; i<test.length; i++) {
			result+=((map.get(test[i])*Math.pow(31, i))%1234567891);
		}
		
		//출력
		System.out.println(result);
		
		
	}
}
