import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        //1일부터 10일 초기화
        for(int i=0; i<10; i++){
            for(int j=0; j<want.length; j++){
                if(discount[i].equals(want[j])) number[j]--;
            }
        }
        
        //할인 받을 수 있나 확인
        boolean isempty = true;
        for(int j=0; j<number.length; j++){
            if(number[j]!=0) isempty=false;    
        }
        if(isempty) answer++;
    
        
        //10일부터 하루씩 반복문 
        for(int i=10; i<discount.length; i++){
            
            //그 전 물건 초기화, 새로운 날 할인 확인
            for(int j=0; j<want.length; j++){
                if(discount[i-10].equals(want[j])) number[j]++;
                if(discount[i].equals(want[j])) number[j]--;
            }
            
            //모든 물건을 할인 받을 수 있나 확인
            isempty = true;
            for(int j=0; j<number.length; j++){
                if(number[j]!=0) isempty=false;    
            }
            if(isempty) answer++;
        }
        
        
        return answer;
    }
}