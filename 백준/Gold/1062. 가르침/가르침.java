import java.util.*;

public class Main {
	
	static int answer;
	static String[] word;
	static char[] choose;
	static List<Character> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		//단어 개수
		int k = sc.nextInt();		//가르칠 수 있는 단어
		
		//단어를 구성하는 알파벳 구하기
		word = new String[n];
		for(int i=0; i<n; i++) {
			word[i] = sc.next();
		}
	
		
		Set<Character> set = new HashSet<>();
		for(int i=0; i<n; i++) {
			String str = word[i];
			for(int j=0; j<str.length(); j++) {
				set.add(str.charAt(j));
			}
		}
		
		//0일 수 밖에 없을 때
		if(k<5) {
			System.out.println(0);
			return;
		}
		
		//n일 수 밖에 없을 때
		if(set.size()<=k) {
			System.out.println(n);
			return;
		}
		
		//알아야 하는 단어 list로 변경
		list = new ArrayList<>();
		for(char ch : set) {
			if(ch!='a' && ch!='n' && ch!='t' && ch!='i' && ch!='c') list.add(ch);
		}
		
		//배울 단어 배열
		choose = new char[k-5];
		
		answer = 0;
		combination(0, 0);
		
        //출력
		System.out.println(answer);
	}
	
	//조합
	public static void combination(int cur, int next) {
		
		if(choose.length<=cur) {

			List<Character> ch = new ArrayList<>();
			for(int i=0; i<choose.length; i++) {
				ch.add(choose[i]);
			}
			
			int result = 0;
			for(int i=0; i<word.length; i++) {
				String str = word[i];
				
				boolean flag = true;
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(j)=='a' || str.charAt(j)=='n' || str.charAt(j)=='t' || 
							str.charAt(j)=='i' || str.charAt(j)=='c') continue;
					if(!ch.contains(str.charAt(j))) {flag=false; break;}
				}
				
				if(flag) result++;
			}

			answer = Math.max(answer, result);
			return;
		}
		
		if(list.size()<=next) return;
	
		choose[cur] = list.get(next);
		combination(cur+1, next+1);
		
		combination(cur, next+1);
	}
}
