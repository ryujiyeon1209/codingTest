import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//중복제거
		Set<Integer> set = new HashSet();
		for(int i=0; i<n; i++) {
			set.add(arr[i]);
		}
		
		int[] arr2 = new int[set.size()];
		int idx = 0;
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			arr2[idx++] = iter.next();
		}
		
		//정렬
		Arrays.sort(arr2);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			int num = arr[i];	//찾아야 하는 수
			
			int start = 0;
			int end = arr2.length-1;
			
			while(start<=end) {
				int mid = (start+end)/2;
				
				if(num<arr2[mid])end = mid-1;
				else if(num>arr2[mid]) start=mid+1; 
				else {
					sb.append(mid + " ");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
