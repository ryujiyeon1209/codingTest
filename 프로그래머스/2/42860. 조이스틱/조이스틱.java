import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int move = name.length()-1;    //좌우로 움직이는 최대 값
        for(int i=0; i<name.length(); i++){
            
            //현재 문자 계산하기
            answer+=Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            
            //A가 끝나는 지점 찾기
            int idx = i+1;
            while(idx<name.length() && name.charAt(idx)=='A'){
                idx++;
            }
            
            //순방향, 역방향 비교하기
            move = Math.min(move, (i*2)+(name.length()-idx));       //순방향
            move = Math.min(move, (((name.length()-idx)*2)+i));    //역방향
        }

                            
        return answer+move;
    }
}