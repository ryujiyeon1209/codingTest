import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//tree 개수를 저장할 map
		Map<String, Integer> map = new HashMap();
		
		int total=0;
		while(sc.hasNextLine()) {
			
			String tree = sc.nextLine();
			total++;
			
			if(map.containsKey(tree)) map.put(tree, map.get(tree)+1);
			else map.put(tree, 1);
		}
		
		//트리 이름 map을 list로 변경 후 정렬
		List<String> treeList = new ArrayList<>(map.keySet());
		Collections.sort(treeList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(int i=0; i<treeList.size(); i++) {
			String name = treeList.get(i);
			int count = map.get(name);
			
			
			double value = (count/(total*1.0))*100;
			System.out.printf("%s %.4f\n", name, value);
			
		}
		
	
	}
}
