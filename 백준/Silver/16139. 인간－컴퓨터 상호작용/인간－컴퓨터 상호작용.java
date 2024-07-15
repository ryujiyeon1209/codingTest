import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] word = sc.next().toCharArray();
		
		List<Integer>[] list = new ArrayList[26];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList();
		}
		
		for(int i=0; i<word.length; i++) {
			list[word[i]-'a'].add(i);
		}
		
		StringBuilder sb = new StringBuilder();

		int test = sc.nextInt();
		for(int t=0; t<test; t++) {
			char ch = sc.next().charAt(0);
			
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			int idx = ch-'a';
			int count = 0;
			for(int i=0; i<list[idx].size(); i++) {
				if(start<=list[idx].get(i) && list[idx].get(i)<=end) count++;
			}
			
			sb.append(count+ "\n");
		}
		
		System.out.println(sb.toString());
	}
}
