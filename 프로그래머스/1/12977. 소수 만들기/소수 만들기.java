import java.util.*;

class Solution {
    
    static List<Integer> list; 
    static int[] sel;
    static int[] num;
    static int answer;
    
    public int solution(int[] nums) {
        
        answer = 0;
        
        num = nums;
        sel = new int[3];
        list = new ArrayList();
        
        prime();
        combination(0, 0);

        return answer;
    }
    
    //1부터 1000까지 소수 모임 메서드
    public static void prime() {
        
        boolean[] check = new boolean[3001];
        for(int i=2; i<check.length; i++){
            check[i] = true;
        }
        
        for(int i=2; i<=Math.sqrt(check.length-1); i++){
            if(!check[i]) continue;
            
            for(int j=i*i; j<=check.length-1; j+=i){
                check[j] = false;
            }   
        }

        for(int i=1; i<check.length; i++){
            if(check[i]) list.add(i);
        }
    }
    
    
    //조합 : 순서 상관 없이 nums에 있는 숫자 중 서로 다른 3개 고르기
    public static void combination(int idx, int val) {
        
        if(3<=idx) {
            int sum = 0;
            for(int i=0; i<sel.length; i++){
                sum+=sel[i];
            }
            
            if(list.contains(sum)) answer++;
            return;
        }
        
        if(num.length<=val) return;
        
        sel[idx] = num[val];
        combination(idx+1, val+1);
        
        combination(idx, val+1);
    } 
    
}