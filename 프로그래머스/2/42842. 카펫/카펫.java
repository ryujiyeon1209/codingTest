import java.util.*;

class Solution {
    
    static List<int[]> list;
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        
        int size = brown+yellow;
        
        list = new ArrayList();
        check(size);
        
        for(int i=0; i<list.size(); i++){
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            
            if((2*x)+(2*y)-4==brown) {
                answer = new int[] {y, x};
                break;
            }
        }
        
        
        return answer;
    }
    
    //약수 구하기
    public static void check(int n) {
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0 && n/i!=i) list.add(new int[] {i, n/i});
            else if(n%i==0 && n/i==i) list.add(new int[] {i, n/i});
        }
    }
}