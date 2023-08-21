import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Integer> queue = new LinkedList();
		
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		
		int m = sc.nextInt();
		int[] arr = new int[m];
		for(int i=0; i<m; i++) {
			arr[i]=sc.nextInt();
		}
		
		int count=0;
		
		int idx=0;
		while(idx<m) {
			
			int targetIdx = queue.indexOf(arr[idx]);
			int halfIdx = queue.size()/2;
					
			if(targetIdx<=halfIdx) {    //절반보다 앞에 있는 원소라면
				for(int i=0; i<targetIdx; i++) {
					int temp = queue.pollFirst();
					queue.add(temp);
					count++;
				}

			} 
			
			else {    //절반보다 뒤에 있는 원소라면
				for(int i=0; i<queue.size()-targetIdx; i++) {
					int temp = queue.pollLast();
					queue.addFirst(temp);
					count++;
				}
			}
			
			queue.remove(0);
			idx++;
		}
		
		//출력
		System.out.println(count);
	}

}
