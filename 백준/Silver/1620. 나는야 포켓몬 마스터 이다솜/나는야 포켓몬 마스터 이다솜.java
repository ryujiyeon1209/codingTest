import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap();
		
		StringBuilder sb = new StringBuilder();
		
		//포켓몬 개수
		int n = sc.nextInt();
		
		//문제 개수
		int m = sc.nextInt();
		
		//포켓몬 이름 입력받고 map에 저장하기
		
		for(int i=1; i<n+1; i++) {
			String num = String.valueOf(i);
			String name = sc.next();
			
			map.put(num, name);	//번호가 key인 경우
			map.put(name, num);	//이름이 key인 경우
		}
		
		
		//문제 입력받기
		for(int i=0; i<m; i++) {
			
			String str = sc.next();				//번호나 이름 입력받기
			sb.append(map.get(str) + " \n");	//StringBuilder에 넣기	
		}
			
		
		//출력
		System.out.println(sb.toString());
		
		
	}
}