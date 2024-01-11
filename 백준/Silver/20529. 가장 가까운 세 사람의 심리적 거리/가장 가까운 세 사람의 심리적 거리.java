import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//비둘기 원리
		//n이 33이상이면 같은 mbti가 3명이 생긴다. > 계산 불필요
		//그 전까지 완전탐색
		
		int test = sc.nextInt();
		for(int t=0; t<test; t++) {
			
			int n = sc.nextInt();

			int min = Integer.MAX_VALUE;
			
			String[] mbti = new String[n];
			for(int i=0; i<n; i++) {
				mbti[i] = sc.next();
			}
			
			if(33<=n) {
				System.out.println("0");
				continue;
			}
			
			for(int i=0; i<mbti.length; i++) {
				for(int j=i+1; j<mbti.length; j++) {
					for(int k=j+1; k<mbti.length; k++) {
						int count = distance(mbti[i], mbti[j], mbti[k]);
						min = Math.min(min, count);
					}
				}
			}
			
			//출력
			System.out.println(min);
			
		}
	}
	
	
	//세사람 거리 계산하기
	public static int distance(String str1, String str2, String str3) {
		
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();
		char[] charArr3 = str3.toCharArray();
		
		int count = 0;
		for(int i=0; i<charArr1.length; i++) {
			if(charArr1[i]!=charArr2[i]) count++;
			if(charArr1[i]!=charArr3[i]) count++;
			if(charArr2[i]!=charArr3[i]) count++;
		}
		
		return count;
	}
}