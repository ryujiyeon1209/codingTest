import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        m=change(m);
        
        String[][] map = new String[musicinfos.length][4];
        for(int i=0; i<musicinfos.length; i++){
            String[] str = musicinfos[i].split(",");
            
            int time = minute(str[0], str[1]);
            String node = change(str[3]);
            
            map[i][0]= String.valueOf(time);
            map[i][1]=str[2];
            map[i][2]=fullNode(time, node);
            map[i][3]=check(m, map[i][2]);
        }

        
        //정렬 : 곡정보 담고 있는지 > 재생시간 내림차순 > 먼저 입력된 순
        Arrays.sort(map, new Comparator<String[]>() {
           public int compare(String[] o1, String[] o2){
               if(Integer.parseInt(o2[3])==Integer.parseInt(o1[3]))
                   return Integer.parseInt(o2[0])-Integer.parseInt(o1[0]);
               return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);
           } 
        });

        
        //조건이 일치하는 경우가 없을 때는 Node 출력
        boolean flag=false;
        for(int i=0; i<map.length; i++){
            if(map[i][3]=="1") flag = true;
        }
        
        if(flag) answer=map[0][1];
        else answer = "(None)";

        return answer;
    }
    
    
    //재생하는 곡에 있는지 확인
    public static String check(String m, String node) {
        if(node.contains(m)) return "1";
        else return "0";
    }
    
    //재생시간 동안 재생된 곡
    public static String fullNode(int time, String m) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<time; i++){
            sb.append(m.charAt(i%m.length()));
        }
        
        return sb.toString();
    }
    
    
    //곡 재생시간 
    public static int minute(String start, String end) {
        String[] stime = start.split(":");
        String[] etime = end.split(":");
        
        int sminute = (Integer.parseInt(stime[0])*60)+Integer.parseInt(stime[1]);
        int eminute = (Integer.parseInt(etime[0])*60)+Integer.parseInt(etime[1]);
        
        return eminute-sminute;
    }
    
    
    //음 변경하기
    public static String change(String m) {
        return m.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");
    }
}

        
                
// for(int i=0; i<map.length; i++){
//     System.out.println(Arrays.toString(map[i]));
// }