import java.util.*;

class Solution {
    public int solution(int n) {
        
        int left=0;     //왼쪽 포인터
        int right=0;    //오른쪽 포인터
        
        int count=0;    //표현 개수
        int sum=0;      //더한 값
        
        while(left<=n && right<=n && left<=right){
           
            if(sum==n) {    //더한 값이 목표 숫자와 같을 때 
                sum+=(++right); 
                count++; 
            } 
            
            else if(sum<n) sum+=(++right);  //더한 값이 작을 때
            else if(sum>n) sum-=(++left);   //더한 값이 클 때
        }
        
        return count;
    }
}