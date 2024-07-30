import java.util.*;

class Solution {
    
    static String sequence;
    static List<String> list;
    static boolean[] isvisited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        
        sequence="";
        list = new ArrayList();
        isvisited = new boolean[tickets.length];
        
        //DFS
        DFS("ICN", tickets);
        
        //사전 순 정렬
        Collections.sort(list);
        
        String airport = list.get(0);
        int idx = 0;
        
        for(int i=0; i<airport.length(); i+=3){
            answer[idx++]=airport.substring(i, i+3);
        }
        
        return answer;
    }
    
    //DFS
    public static void DFS(String str, String[][] tickets) {
        
        sequence+=str;
        
        //항공권을 모두 이용했는지 확인
        boolean flag = true;
        for(int i=0; i<tickets.length; i++){
            if(!isvisited[i]) flag = false;
        }
        
        if(flag) {
            list.add(sequence);
            return;
        }
        
        
        //다음 경로 찾기
        for(int i=0; i<tickets.length; i++){
            if(isvisited[i]) continue;
            if(tickets[i][0].equals(str)) {
                isvisited[i]=true;
                DFS(tickets[i][1], tickets);
                
                isvisited[i]=false;
                sequence= sequence.substring(0, sequence.length()-3);
            }
        }
    }
}