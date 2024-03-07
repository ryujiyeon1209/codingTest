import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		Map<Character, Integer> map = new HashMap();
		for(int i=0; i<str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}
		
		//펠린드롬 만들 수 없다면
		int odd = 0;
		for(int value : map.values()) {
			if(value%2!=0) odd++;
			if(2<=odd) { System.out.println("I'm Sorry Hansoo"); return; }
		}
		
		//사전 순으로 정렬
		int idx = 0;
		char[] chArr = new char[map.size()];
		for(char key : map.keySet()) {
			chArr[idx++] = key;
		}
		
		Arrays.sort(chArr);
		
		
		//펠린드롬 배열
		char[] answer = new char[str.length()];
		int start = 0;
		int end = answer.length-1;
		
		for(char ch : chArr) {
			//짝수개라면
			if(map.get(ch)%2==0) {
				for(int i=0; i<map.get(ch); i+=2) {
					answer[start++]=ch;
					answer[end--]=ch;
				}
			}
			//홀수라면
			else {
				for(int i=0; i<map.get(ch)-1; i+=2) {
					answer[start++]=ch;
					answer[end--]=ch;
				}
				answer[answer.length/2]=ch;
			}
		}
		
		//출력
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]);
		}
	}	
}
