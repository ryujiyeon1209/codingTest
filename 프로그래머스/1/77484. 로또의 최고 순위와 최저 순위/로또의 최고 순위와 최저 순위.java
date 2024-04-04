import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        List<Integer> list = new ArrayList();
        for(int i=0; i<win_nums.length; i++){
            list.add(win_nums[i]);
        }
        
        int max = 0;        //최대 값
        int min = 0;        //최소 값
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                max++;
            } else if(list.contains(lottos[i])) {
                max++; min++;
            }
        }
        
        //등수로 변경하기
        max = (max!=0) ? 7-max : 6;
        min = (min!=0) ? 7-min : 6;
        
        int[] answer = {max, min};
        return answer;
    }
}