import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//회사에 있는 사람 명수
		int n = sc.nextInt();
	
		//리스트 생성 및 초기화
		Map<String, String> map = new HashMap();

		
		//직원들 출퇴근 정보 받기
		for(int i=0; i<n; i++) {
			String name = sc.next();
			String isWork = sc.next();
			
			//이미 map에 존재하는 직원이라면, 퇴근한 것이므로 map에서 삭제
			//아니라면, 출근한 것이므로 map에 삽입
			
			if(map.containsKey(name)) map.remove(name);
			else map.put(name, isWork);
		}
		
		//key를 list로 바꾼 후 역순으로 정렬
		List<String> list = new ArrayList(map.keySet());
		Collections.sort(list, Collections.reverseOrder());
		
		//출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
