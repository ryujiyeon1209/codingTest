import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] str = sc.nextLine().toCharArray();
		char[] search = sc.nextLine().toCharArray();
		
		int count=0;
		for(int i=0; i<=str.length-search.length; i++) {
			
			//완전탐색 시작
			boolean flag = true;
			for(int j=0; j<search.length; j++) {
				if(str[i+j]!=search[j]) { flag=false; break; }
			}
			
			//찾고자 하는 단어가 있다면,
			if(flag) {
				count++;
				i+=search.length-1;
			}
		}
		
		//출력
		System.out.println(count);
		
	}
}
