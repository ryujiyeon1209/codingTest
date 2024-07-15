import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] word = br.readLine().toCharArray();
		
        //누적합
		int[][] dp = new int[26][word.length+1];
		for(int i=0; i<word.length; i++) {
			
			int idx = word[i]-'a';
			
			for(int j=0; j<dp.length; j++) {
				if(j==idx) dp[j][i+1]= dp[j][i]+1;
				else dp[j][i+1]= dp[j][i];
			}
		}

		StringBuilder sb = new StringBuilder();
		
        int test = Integer.parseInt(br.readLine());
		for(int t=0; t<test; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str); 
			
			char ch = st.nextToken().charAt(0);
			
			int start = Integer.parseInt(st.nextToken())+1;
			int end = Integer.parseInt(st.nextToken())+1;
			
			int idx = ch-'a';
			sb.append((dp[idx][end]-dp[idx][start-1])+ "\n");
		}
		
        //출력
		System.out.println(sb.toString());
	}
}
