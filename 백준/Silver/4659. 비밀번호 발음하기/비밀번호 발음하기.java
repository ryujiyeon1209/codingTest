import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			//문자열 입력받기
			String str = sc.next();
			char[] ch = str.toCharArray();
			
			//문자열 문자리스트로 변경
			List<Character> word = new LinkedList();
			for(int i=0; i<ch.length; i++) {
				word.add(ch[i]);
			}
			
			//반복문 종료조건
			if(str.equals("end")) break;
			
			boolean result = Solution(word);
			
			//출력
			if(result) System.out.printf("<%s> is acceptable.\n", str);
			else System.out.printf("<%s> is not acceptable.\n", str);
		}
	}
	
    
    
	public static boolean Solution(List<Character> word) {
		
		//조건 1. 모음이 없을 경우	
		for(int i=0; i<5; i++) {			
			if(!word.contains('a') && !word.contains('e') && !word.contains('i') 
					&& !word.contains('o') && !word.contains('u'))  return false;
		}

		if(word.size()<2) return true;
		
		//조건 2. 동일한 문자가 연속이지 말것
		for(int i=0; i<word.size()-1; i++) {
			if(word.get(i)==word.get(i+1) && (word.get(i)!='e' && word.get(i)!='o')) return false;
		}
		
		if(word.size()<3) return true;
		
		//조건 3. 모음과 자음이 3개 연속일 때
		int count1=0, count2=0;						
		for(int i=0; i<word.size(); i++) {
			
			//모음
			if(word.get(i)=='a' || word.get(i)=='e'|| word.get(i)=='i' || 
					word.get(i)=='o' || word.get(i)=='u') { count1++; count2=0;}
			//자음
			else {count1=0; count2++;}
			
			if(count1==3 || count2==3) return false;
		}
		
		return true;
	}
}
