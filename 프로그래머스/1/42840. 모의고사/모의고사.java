import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        //2번 수포자, 3번 수포자 정답 배열 만들기
        int[] onans = {1, 2, 3, 4, 5};
        int[] twans = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thans = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] one = new int[answers.length];
        for(int i=0; i<one.length; i++){
            one[i] = onans[(i%onans.length)];;
        }
        
        int[] two = new int[answers.length];
        for(int i=0; i<two.length; i++){
            two[i] = twans[(i%twans.length)];
        }
        
        int[] three = new int[answers.length];
        for(int i=0; i<three.length; i++){
            three[i] = thans[(i%thans.length)];
        }
        
        //정답 체크하기
        int[] count = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i]==one[i]) count[0]++;
            if(answers[i]==two[i]) count[1]++;
            if(answers[i]==three[i]) count[2]++;
        }
        
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        
        int size = 0;
        for(int i=0; i<count.length; i++){
            if(count[i]==max) size++;
        }
        
        //배열 생성
        int[] answer = new int[size];
        
        int idx = 0;
        for(int i=0; i<count.length; i++){
            if(count[i]==max) answer[idx++] = i+1; 
        }
        
        return answer;
    }
}