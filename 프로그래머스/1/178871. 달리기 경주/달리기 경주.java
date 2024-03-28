import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
 
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++){
            String name = callings[i];      //역전 선수 이름
            int rank = map.get(name);       //현재 등수

            String fname = players[rank-1]; //역전 당한 선수 이름
            int frank = map.get(fname);     //현재 등수
            
            swap(players, rank, map.get(players[rank-1]));
                
            map.put(name, rank-1);           //역전 선수 등수 바꾸기
            map.put(fname, frank+1);        //역전 당한 선수 등수 바꾸기
        }
        
        return players;
    }
    
    //배열 등수 바꾸기
    public static String[] swap(String[] players, int a, int b){
        String tmp = players[a];
        players[a] = players[b];
        players[b] = tmp;
        
        return players;
    }
}