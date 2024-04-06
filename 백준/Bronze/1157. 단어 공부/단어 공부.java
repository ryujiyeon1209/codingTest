import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//문자열 입력받고 대문자로 변경
		String str = sc.next().toUpperCase();
		
		//문자 사용 횟수 구하기
		Map<Character, Integer> map = new HashMap(); 
		for(int i=0; i<str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}
		
		//가장 많이 사용한 횟수와 문자 찾기
		int max = 0;
		String answer = "";
		for(char ch : map.keySet()) {
			if(max<map.get(ch)) {
				max = map.get(ch);
				answer = String.valueOf(ch);
			}
		}
		
		//가장 많은 문자가 여러개인지 확인
		int count = 0;
		for(char ch : map.keySet()) {
			if(max==map.get(ch)) {
				count++;
				answer = String.valueOf(ch);
			}
			
			if(1<count) {answer = "?"; break;}
		}
		
		//출력
		System.out.println(answer);
		
	}
}
