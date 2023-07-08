import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        //이름을 담을 배열 리스트로 변환
        List<String> nameList = Arrays.asList(name);
        
        //정답배열 생성
        int[] answer = new int[photo.length];
        
        //그리움 점수 매기기
        for(int i=0; i<photo.length; i++){
            int score=0;
            for(int j=0; j<photo[i].length; j++){
                int num = nameList.indexOf(photo[i][j]);
                
                if(num<0) continue;
                else score += yearning[num];
            }
            answer[i]=score;
        }
        
        return answer;
    }
}