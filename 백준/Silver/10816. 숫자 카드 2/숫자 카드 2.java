import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//카드 개수 입력받기
		int n = sc.nextInt();
		
		//map생성
		Map<Integer, Integer> map = new HashMap();
		
		//map에 숫자 저장
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		//출력을 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		//상근이가 가지고 있는 숫자 개수 입력받기
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int num=sc.nextInt();
			
			if(map.containsKey(num)) sb.append(map.get(num)+ " ");
			else sb.append(0 + " ");
		}
		
		//출력
		System.out.println(sb.toString());
		
	}
}
