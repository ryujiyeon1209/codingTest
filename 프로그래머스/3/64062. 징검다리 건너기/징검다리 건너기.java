import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 0;
        int max = 200000000;
        
        //이분 탐색
        while(min<=max){
            
            //징검다리 건더는 니니즈 친구들 수
            int mid = (min+max)/2;
            
            
            boolean flag = true;
            
            //디딤돌이 0이 되는 수
            int count = 0;
            for(int i=0; i<stones.length; i++){
                if(stones[i]<mid) count++;
                else count=0;
                
                if(k<=count) flag =false;
            }

            //탐색 범위 변경하기
            if(!flag) max = mid-1;
            else min = mid+1;
        }
        
        answer = max;
        return answer;
    }  
}