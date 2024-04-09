import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//파일 개수 입력받기
		int n = sc.nextInt();
		
		//확장자 이름과 개수 저장하기
		Map<String, Integer> map = new HashMap();
		for(int i=0; i<n; i++) {
			String[] type = sc.next().split("\\.");
			map.put(type[1], map.getOrDefault(type[1], 0)+1);
		}
		
		//정렬
		List<String> list = new ArrayList(map.keySet());
		Collections.sort(list);
		
		//StringBuilder에 저장
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			String type = list.get(i);
			sb.append(type +" "+ map.get(type));
			sb.append("\n");
		}
		
		//출력
		System.out.println(sb.toString());
		
	}
}
