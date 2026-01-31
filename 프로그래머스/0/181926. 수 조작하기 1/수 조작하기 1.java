import java.util.*;

class Solution {
    public int solution(int n, String control) {
       
        for(int i=0; i<control.length(); i++){
            String str = control.substring(i, i+1);
            
            if("w".equals(str)) n+=1;
            else if("s".equals(str)) n-=1;
            else if("d".equals(str)) n+=10;
            else n-=10;
            
        }
        
        return n;
    }
}