import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<test; t++) {
			
			//수첩1 확인
			int n = sc.nextInt();
			Map<Integer, Integer> map = new HashMap();
			for(int i=0; i<n; i++) {
				int num = sc.nextInt();
				map.put(num, map.getOrDefault(num, 0)+1);
			}
			
			//수첩2 확인
			int m = sc.nextInt();
			for(int i=0; i<m; i++) {
				int check = sc.nextInt();
				if(map.containsKey(check)) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
		}
		
		//출력
		System.out.println(sb.toString());

	}
}
