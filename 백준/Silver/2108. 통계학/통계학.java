import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		double sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
			
		Map<Integer, Integer> map = new HashMap();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(max<=map.get(arr[i])) max=map.get(arr[i]);
		}
	
		List<Integer> list = new ArrayList();
		for(int i=0; i<arr.length; i++) {
			if(max==map.get(arr[i]) && !list.contains(arr[i])) list.add(arr[i]);
		}
	
		int key = 0;
		key = (2<=list.size()) ? list.get(1) : list.get(0);
		
		System.out.println(Math.round(sum/arr.length));
		System.out.println(arr[arr.length/2]);
		System.out.println(key);
		System.out.println(arr[arr.length-1] - arr[0]);
	}
}
