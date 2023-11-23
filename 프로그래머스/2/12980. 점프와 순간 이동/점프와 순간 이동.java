import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int ans=1;
        while(2<=n){
            if(n%2==1) ans+=1;
            n/=2;
        }

        return ans;
    }
}