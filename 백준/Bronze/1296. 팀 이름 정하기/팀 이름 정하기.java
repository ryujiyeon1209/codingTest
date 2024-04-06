import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//연두 이름
		String str = sc.next();
		
		//기준이 되는 이름
		char[] chArr = new char[] {'L', 'O', 'V', 'E'};
		
		//팀 이름 후보 개수
		int n = sc.nextInt();
		
		//팀 이름 후보 입력받기
		String[] name = new String[n];
		for(int i=0; i<n; i++) {
			name[i] = sc.next();
		}
		
		//오름차순으로 정렬
		Arrays.sort(name);
		
		int max = 0;
		String win = "";
		
		for(int t=0; t<n; t++) {
			Map<Character, Integer> map = new HashMap();
			
			//연두의 이름과 팀 이름의 문자 횟수 구하기
			for(int i=0; i<str.length(); i++) {
				map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
			}
			
			for(int i=0; i<name[t].length(); i++) {
				map.put(name[t].charAt(i), map.getOrDefault(name[t].charAt(i),0)+1);
			}
			
			//우승할 확률 구하기
			int sum = 1;
			for(int i=0; i<chArr.length; i++) {
				for(int j=i+1; j<chArr.length; j++) {
					int tmp = 0;
					if(map.containsKey(chArr[i])) tmp+=map.get(chArr[i]);
					if(map.containsKey(chArr[j])) tmp+=map.get(chArr[j]);
					
					sum*=tmp;
					sum%=100;
				}
			}
			
			if(win.equals("")) win = name[t];
			
			//우승확률이 제일 높은 이름 고르기
			if(max<sum) {
				max = sum;
				win = name[t];
			} 
		}
		
		//출력
		System.out.println(win);
	}
}
