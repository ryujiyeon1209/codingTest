import java.util.*;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int t=0; t<test; t++) {

			int num = sc.nextInt();
			Map<String, Integer> map = new HashMap();
			
			//여기서 dafault값이 1인 이유는 이 옷을 입지 않았을 경우도 생각해야 하기 때문!
			for(int i=0; i<num; i++) {				
				String fashion = sc.next();
				String type = sc.next();
				map.put(type, map.getOrDefault(type, 1)+1);
			}
			
			//조합 
			int answer = 1;
			for(int val : map.values()) {
				answer*=val;
			}
			
			//출력 : 아무것도 입지 않았을 경우를 생각해서 -1를 해야 한다
			System.out.println(answer-1);
		}
	}
	
	
	
}
