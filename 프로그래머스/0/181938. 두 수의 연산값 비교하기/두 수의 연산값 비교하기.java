import java.util.*;

class Solution {
    public int solution(int a, int b) {
        
        //num1 계산
        int num1 = Integer.parseInt(a+""+b);
        
        //num2 계산
        int num2 = 2*a*b;
    
        if(num1>=num2) return num1;
        else return num2;
    }
}