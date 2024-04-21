import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        //펄스 수열
        long[] arr1 = new long[sequence.length];
        for(int i=0; i<arr1.length; i++){
            if(i%2==0) arr1[i] = sequence[i];
            else arr1[i] = sequence[i] * -1;
        }
        
        //dp
        long[] dp = new long[arr1.length];
        dp[0] = arr1[0];
        
        for(int i=1; i<dp.length; i++){
            if(arr1[i]<=dp[i-1]+arr1[i]) dp[i] = dp[i-1]+arr1[i];
            else dp[i] = arr1[i];
        }
        
        //최대값 찾기
        for(int i=0; i<dp.length; i++){
            if(answer<dp[i]) answer = dp[i];
        }
        
        //펄스 수열2
        long[] arr2 = new long[sequence.length];
        for(int i=0; i<arr2.length; i++){
            if(i%2==0) arr2[i] = sequence[i] * -1;
            else arr2[i] = sequence[i];
        }
        
        //dp 2
        dp = new long[arr2.length];
        dp[0] = arr2[0];
        
        for(int i=1; i<dp.length; i++){
            if(arr2[i]<=dp[i-1]+arr2[i]) dp[i] = dp[i-1]+arr2[i];
            else dp[i] = arr2[i];
        }
        
        //최대값 찾기2
        for(int i=0; i<dp.length; i++){
            if(answer<dp[i]) answer = dp[i];
        }

        return answer;
    }
}