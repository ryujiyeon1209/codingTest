import java.util.*;

public class Main {
	
	static Map<String, Boolean> map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();		//최초 값
		int p = sc.nextInt();		//제곱수
		
		//반복수열을 저장할 map
		map = new HashMap();					
		
		//DFS 실행
		map.put(a, true);
		DFS(a, p);
		
		//반복수열 제외 개수 세기
		int answer = 0;
		for(String str : map.keySet()) {
			if(map.get(str)) answer++;
		}
		
		//출력
		System.out.println(answer);
	}
	
	//DFS
	public static void DFS(String a, int p) {
	
		//계산하기
		int result = 0;
		char[] chArr = a.toCharArray();
		for(int i=0; i<chArr.length; i++) {
			result+=Math.pow(chArr[i]-'0', p);
		}
		
		String str = String.valueOf(result);
		
		//이미 존재하는 숫자인데, 다시 왔다면
		if(map.containsKey(str) && map.get(str)) {
			map.put(str, false);
			DFS(str, p);
		}
		
		//이미 존재하는 숫자인데, 2번 다시 왔다면
		else if(map.containsKey(str) && !map.get(str)) {
			return;
		}
		
		//새로운 숫자라면,
		else if(!map.containsKey(str)) {
			map.put(str, true);
			DFS(str, p);
		}	
	}
}
