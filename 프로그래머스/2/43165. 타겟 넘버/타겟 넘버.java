import java.util.*;

class Solution {
    
    static int count;
    static List<Integer>[] list;
    static int[] select;
    
    public int solution(int[] numbers, int target) {
        
        //인접리스트 생성
        list = new List[numbers.length];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<list.length; i++){
            list[i].add(0);
            list[i].add(1);
        }
        
        //+-선택
        select = new int[numbers.length];
        
        DFS(0, numbers, target);
        
        return count;
    }
    
    //DFS
    public static void DFS(int idx, int[] numbers, int target) {
        
        if(select.length<=idx) {
            
            int sum = 0;
            for(int i=0; i<select.length; i++){
                if(select[i]==0) sum+=numbers[i];
                else sum-=numbers[i];
            }
            
            if(sum==target) count++;
            return;
        }
        
        for(int i=0; i<list[idx].size(); i++){
            select[idx] = list[idx].get(i);
            DFS(idx+1, numbers, target);
        }
    }
}