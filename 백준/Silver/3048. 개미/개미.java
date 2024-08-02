import java.util.*;

public class Main {
	
	static char[] charr; 
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		
		char[] n1 = sc.next().toCharArray();
		char[] n2 = sc.next().toCharArray();
		
		charr = new char[s1+s2];
		for(int i=0; i<n1.length; i++) {
			charr[i] = n1[s1-1-i];
		}
		for(int i=0; i<n2.length; i++) {
			charr[i+s1]=n2[i];
		}
		
		//방향 표시
		Map<Character, Integer> map = new HashMap();
		for(int i=0; i<s1; i++) {
			map.put(charr[i], 1);
		}
		for(int i=0; i<s2; i++) {
			map.put(charr[s1+i], 0);
		}
		
		//자리바꾸기
		int time=0;
		int t= sc.nextInt();
		while(time<t) {
			
			List<Integer> list = new ArrayList();
			for(int i=0; i<charr.length-1; i++) {
				if(map.get(charr[i])==1 &&
						map.get(charr[i+1])==0) list.add(i);
			}

			for(int i=0; i<list.size(); i++) {
				swap(list.get(i));
			}
			
			time++;
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<charr.length; i++) {
			sb.append(charr[i]);
		}
		
		System.out.println(sb.toString());
	}
	
	//자리 바꾸기
	public static void swap(int idx) {
		char ch1 = charr[idx];
		char ch2 = charr[idx+1];
		
		charr[idx]=ch2;
		charr[idx+1]=ch1;
	}
}
