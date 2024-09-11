import java.util.*;

class Solution {
    
    static char[] charr;
    static char[] choose;
    static Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        
        map = new HashMap();
        for(int t=0; t<orders.length; t++){
            
            //손님이 주문한 메뉴
            charr = orders[t].toCharArray();    
            Arrays.sort(charr);
            
            //코스 요리 개수
            for(int i=0; i<course.length; i++){
                choose = new char[course[i]];
                combination(0, 0);
            }
        }
        
        //2명 이상의 손님으로부터 주문된 메뉴인지 확인,
        //코스 크기 당 가장 많이 시킨 메뉴인지 확인
        List<String> list = new ArrayList();
        for(int i=0; i<course.length; i++){
            int size = course[i];
            int max = 2;
            for(String menu : map.keySet()){
                if(menu.length()==size && max<=map.get(menu)) {
                    max = map.get(menu);
                }
            }
            
            for(String menu : map.keySet()){
                if(menu.length()==size && max==map.get(menu)) {
                    list.add(menu);
                }
            }
        }

        
        //배열로 변경
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        //정렬
        Arrays.sort(answer);
        
        return answer;
    }
    
    
    //코스 메뉴 조합 만들기
    public static void combination(int idx, int value) {
        if(choose.length<=idx) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<choose.length; i++){
                sb.append(choose[i]);
            }
            
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            return;
        }
        
        if(charr.length<=value) return;
        
        choose[idx]=charr[value];
        combination(idx+1, value+1);
        
        combination(idx, value+1);
    }
    
    
}