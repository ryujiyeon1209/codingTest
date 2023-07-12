import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        //brown + yellow가 카펫의 넓이 > 가로 * 세로
        //따라서 brown + yellow의 약수를 구해서 해결하기!
        
        int[] answer = {};
        int area = brown+yellow;
        
        //가로 세로를 담을 리스트 생성
        List<int[]> list = new ArrayList();
        
        //약수 구하기
        for(int i=1; i<=Math.sqrt(area); i++){           
            if(area%i==0) { list.add(new int[] {area/i, i}); }   //약수 구하기
        }

        //가로 길이가 brown의 개수와 맞는지 확인
        for(int i=0; i<list.size(); i++){
            int r = list.get(i)[0];     //가로
            int c = list.get(i)[1];     //세로
            
            if(((2*r)+(2*c)-4)==brown) answer=list.get(i);
        }
        
        return answer;
    }
}