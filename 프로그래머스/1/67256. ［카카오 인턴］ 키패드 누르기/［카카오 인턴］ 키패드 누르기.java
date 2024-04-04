import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        //왼손, 오른손 초기 위치
        int[] l = {3, 0};
        int[] r = {3, 2};
        
        //키패드 자리 초기화
        Map<Integer, int[]> map = new HashMap();
        map.put(0, new int[] {3, 1});
        
        int idx = 1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                map.put(idx++, new int[] {i, j});
            }
        }
        
        //왼손 사용인지 오른손 사용인지 확인하기
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            
            //왼쪽 손가락으로만 누르는 경우
            if(num==1 || num==4 || num==7) {
                answer+="L";
                l = map.get(num);
            }
            
            //오른쪽 손가락으로만 누르는 경우
            else if(num==3 || num==6 || num==9) {
                answer+="R";
                r = map.get(num);
            }
            
            //비교해야 하는 경우
            else {
                int[] cur = map.get(num);
            
                int lcount = Math.abs(l[0]-cur[0]) + Math.abs(l[1]-cur[1]);
                int rcount = Math.abs(r[0]-cur[0]) + Math.abs(r[1]-cur[1]);
                
                if(lcount>rcount) {
                    r = map.get(num);
                    answer+="R";
                } else if(lcount<rcount) {
                    l = map.get(num);
                    answer+="L";
                } else if(lcount==rcount && hand.equals("right")) {
                    r = map.get(num);
                    answer+="R";
                } else {
                    l = map.get(num);
                    answer+="L";
                }
            }
        }
        
        return answer;
    }
}