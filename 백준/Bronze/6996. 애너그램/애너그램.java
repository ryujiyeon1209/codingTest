import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=0; t<test; t++) {
			
			//단어 입력받기
			String str1 = sc.next();
			String str2 = sc.next();
			
			//str1 알페벳 개수 세기
			int[] arr1 = new int[26];	
			for(int i=0; i<str1.length(); i++) {
				arr1[str1.charAt(i)-'a']++;
			}
			
			//str2 알페벳 개수 세기
			int[] arr2 = new int[26];
			for(int i=0; i<str2.length(); i++) {
				arr2[str2.charAt(i)-'a']++;
			}
			
			//애너그램 확인하기
			boolean flag = true;
			for(int i=0; i<arr1.length; i++) {
				if(arr1[i]!=arr2[i]) { flag= false; break; }
			}
			
			//출력
			if(flag) System.out.printf("%s & %s are anagrams.", str1, str2);
			else System.out.printf("%s & %s are NOT anagrams.", str1, str2);
			System.out.println();
		}
	}
}
