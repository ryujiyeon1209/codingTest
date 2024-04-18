import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//최초값 입력받기
		String num = sc.next();
		
		//순서, 중복제거를 위한 queue, set
		Queue<String> queue = new LinkedList();
		queue.add(num);
		
		Set<Integer> set = new HashSet();
		set.add(Integer.parseInt(num));
		
		while(true) {
			String cur = queue.poll();

			int sum = 0;
			for(int i=0; i<cur.length(); i++) {
				sum+=(cur.charAt(i)-'0');
			}
			
			//새로운 숫자 만들기
			String now = ""; 
			now+=cur.charAt(cur.length()-1);
			now+=String.valueOf(sum).charAt(String.valueOf(sum).length()-1);
			
			//중복되었나 확인하기
			int size = set.size();
			set.add(Integer.parseInt(now));
			
			if(set.size()==size) break;
			else queue.add(now);
			
		}
		
		//출력
		System.out.println(set.size());
	}
}
