import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        //체육복 도난 당한 사람 정렬하기
        Arrays.sort(lost);
        
        //빌려줄 수 있는 사람 체크하기
        boolean[] isCloth = new boolean[n+1];
        for(int i=0; i<reserve.length; i++){
            isCloth[reserve[i]] = true;
        }
        
        //체육복 빌리기
        for(int i=0; i<lost.length; i++){
            int num = lost[i];
            
            if(isCloth[num]==true) {    //자기 자신한테 빌리기
                answer++;
                isCloth[num]=false;
            }
            else if(0<=num-1 && isCloth[num-1]==true) { //앞사람한테 빌리기
                answer++;
                isCloth[num-1]=false;
            }
            else if(num+1<=n && isCloth[num+1]==true) { //뒷사람한테 빌리기
                if(i+1<lost.length && lost[i+1]==num+1) continue;
                answer++;
                isCloth[num+1]=false; 
            } 
 
        }
        
        return answer;
    }
}