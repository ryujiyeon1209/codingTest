import java.util.*;

class Solution {
    
    static List<Integer>[] list; 
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //인덱스 저장
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], i);
        }
        
        //인접리스트 생성
        list = new ArrayList[id_list.length];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        //경고한 사람, 경고 당한 사람 저장
        Set<String> set = new HashSet();
        for(int i=0; i<report.length; i++){
            
            int size = set.size();
            set.add(report[i]);
            if(set.size()==size) continue;
            
            String warn = report[i].split(" ")[0];
            String warned = report[i].split(" ")[1];
            
            list[map.get(warned)].add(map.get(warn));
        }
        
        //메일 발송
        for(int i=0; i<list.length; i++){
            if(list[i].size()<k) continue;
            
            for(int j=0; j<list[i].size(); j++){
                answer[list[i].get(j)]++;
            }
        }
        
        return answer;
    }
}