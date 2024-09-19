import java.util.*;

class Solution {
    
    static Set<String> set;
    static boolean[] isvisited;
    static List<Integer>[] list;
    static int answer;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        
        //인접리스트 생성
        list = new List[banned_id.length];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        
        //인접리스트 값 저장
        for(int i=0; i<banned_id.length; i++){
            String bann = banned_id[i];
            
            for(int j=0; j<user_id.length; j++){
                String user = user_id[j];
                if(bann.length()!=user.length()) continue;
                
                boolean flag = true;
                for(int k=0; k<bann.length(); k++){
                    if(bann.charAt(k)!='*' && 
                        bann.charAt(k)!=user.charAt(k)) flag=false;
                }
                
                if(flag) list[i].add(j);
            }
        }
        
        set = new HashSet();
        isvisited = new boolean[user_id.length];
        
        DFS(user_id, 0);
        
        return answer;
    }
    
    
    //조합
    public static void DFS(String[] user_id, int idx) {
        
        //중복제거
        if(list.length<=idx) {
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<isvisited.length; i++){
                if(isvisited[i]) sb.append(i);
            }
            
            if(set.contains(sb.toString())) return;
            else set.add(sb.toString());

            answer++;
            
            return;
        }
        
        
        for(int i=0; i<list[idx].size(); i++){
            int banuser = list[idx].get(i);
            if(isvisited[banuser]) continue;
            
            isvisited[banuser]=true;
            DFS(user_id, idx+1);
            
            isvisited[banuser]=false;
        }
        
    }
}