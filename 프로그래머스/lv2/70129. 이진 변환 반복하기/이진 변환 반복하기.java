import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int zCount=0; //0의 개수
        int cCount=0; //2진법 변환 횟수
        String str=s;
        
        while(!str.equals("1")) {
            
            char[] chList = str.toCharArray();
        
            int oCount=0;   //1의 개수
            for(int i=0; i<chList.length; i++){
                if(chList[i]=='1') oCount++;
                else zCount++;
            }

            StringBuilder sb = new StringBuilder();
            cCount++;
            while(0<oCount){
                int tmp = (oCount%2);
                sb.append(tmp);

                oCount/=2;
            }
            
            str=sb.reverse().toString();
            if(str.equals("1")) break;
        }
        
        int[] answer = {cCount, zCount};
        return answer;
    }
}