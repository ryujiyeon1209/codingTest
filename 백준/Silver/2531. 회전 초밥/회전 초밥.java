import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//회전벨트에 놓인 접시의 수
		int d = sc.nextInt();	//초밥의 가짓 수
		int k = sc.nextInt();	//연속해서 먹는 접시의 수
		int c = sc.nextInt();	//쿠폰번호 
		
		//회전 벨트 배열 생성 및 값 입력받기
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}

		
		int result=0;
		
		//다른 종류를 먹는지 확인하는 set
		Map<Integer, Integer> map = new HashMap();
		for(int i=0; i<k; i++) {
			if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
			else map.put(arr[i], 1);
		}
		
		//연속으로 k개를 먹지 못할 경우를 위해
		List<Integer> list = new LinkedList();
		
		//경우의 수
		for(int i=0; i<n; i++) {
			
			//map에 있는 초밥의 종류와 k 비교
			if(!map.containsKey(c)) list.add(map.size()+1);
			else list.add(map.size());

			
			//같은 종류의 초밥이 2개 이상이라면 개수를 -1 하자
			if(map.get(arr[i])>1) map.put(arr[i], map.get(arr[i])-1);
			else map.remove(arr[i]);
			
			//k+1 초밥 종류를 map에 넣기
			int input = (i+k) < n ? i+k : Math.abs(i+k-n);
			map.put(arr[input], map.getOrDefault(arr[input], 0)+1);		
			
		}
		
		//출력
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		
	}
}
