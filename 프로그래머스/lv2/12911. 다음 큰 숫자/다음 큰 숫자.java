import java.util.*;

class Solution {
    public int solution(int n) {
        
        //1. n을 2진수로 바꾸고 1의 개수를 세기
        char[] nBinary= changeBinary(n).toCharArray();
        
        int nCount=0;
        for(int i=0; i<nBinary.length; i++){
            if(nBinary[i]=='1') nCount++;
        }
        
        //2. tmp를 n+1로 초기화한한다.
        int tmp=n+1;
        while(true){
            
            //3. tmp를 2진수 후 1의 개수와 nCount와 비교한다.
            char[] tmpBinary= changeBinary(tmp).toCharArray();
            
            int tmpCount=0;
            for(int i=0; i<tmpBinary.length; i++){
                if(tmpBinary[i]=='1') tmpCount++;
            }
            
            if(tmpCount==nCount) break;
            else tmp++;
        }

        return tmp;
    }
    
    
    //2진수로 변경 메소드
    public static String changeBinary(int n){    
        StringBuilder sb = new StringBuilder();
        while(0<n){
            sb.append(String.valueOf(n%2));
            n/=2;
        }
        
        return sb.toString();
    }
    
}