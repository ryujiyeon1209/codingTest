import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//수강신청 성공 인원
		int m = sc.nextInt();	//수강신청 인원
	
		
		//map 생성 및 값 입력받기
		Map<String, Integer> map = new HashMap();
		for(int i=0; i<m; i++) {
			map.put(sc.next(), i);
		}
		
		//순서를 인덱스로 key 저장하기
		String[] arr = new String[m];
		for(String key : map.keySet()) {
			arr[map.get(key)] = key;
		}

		//출력
		int count=0; int idx=0;
		while(count<n && idx<m) {
			if(arr[idx]!=null) {
				System.out.println(arr[idx]);
				count++;
			} 
			
			idx++;
		}
		
	}
}
