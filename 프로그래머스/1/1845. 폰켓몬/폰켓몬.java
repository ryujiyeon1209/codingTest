import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        //포켓몬 종류 개수 구하기
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        //최대 가질 수 있는 종류 구하기
        if(map.size()<=nums.length/2) answer = map.size();
        else answer = nums.length/2;
        
        return answer;
    }
}