import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,String> map = new HashMap();
		Map<String, Integer> map2 = new HashMap();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.next();
			map.put(i, arr[i]);
			map2.put(arr[i], i);
		}
		for(int i=0; i<M; i++) {
			String str = sc.next();
			if(isInteger(str)) {
				int num = Integer.parseInt(str);
				System.out.println(arr[num-1]);
			}else {
				System.out.println(map2.get(str)+1);
			}
			
		}
		
	}
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}catch (NumberFormatException ex) {
			return false;
		}
	}
}