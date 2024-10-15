import java.util.*;

class Solution {
    
    static int[][] map;
    static Stack<Integer> stack;
    
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        //표 생성
        map = new int[n][3];
        
        //순서 정보 입력하기
        for(int i=0; i<map.length; i++){
            map[i][0]=i-1;
            map[i][1]=i;
            map[i][2]=i+1;
        }
        
        //삭제 정보 저장 stack
        stack = new Stack();
        
        //명령어 수행
        for(int i=0; i<cmd.length; i++){

            char ch = cmd[i].charAt(0);
            
            //X칸 위로 가기
            if(ch=='U') { 
                String[] command = cmd[i].split(" ");
                int x = Integer.parseInt(command[1]);
                
                k = up(k, x);
            }
            
            
            //X칸 아래로 가기
            else if(ch=='D') {
                String[] command = cmd[i].split(" ");
                int x = Integer.parseInt(command[1]);
                
                k = down(k, x);
            } 
                
            //삭제하기
            else if(ch=='C') {
                k=remove(k);
            }
            
            //복구하기
            else if(ch=='Z') {
                restore();
            }
        }
        
        //삭제된 정보 표시
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            map[tmp][1]=-1;
        }
        
        //정답 반환
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<map.length; i++){
            if(map[i][1]!=-1) sb.append("O");
            else sb.append("X");
        }
        
        answer = sb.toString();
        return answer;
    }
    
    //X칸 위로 가기
    public static int up(int cur, int x) {
        if(x==0) return cur;
        if(cur==0) return cur;
        return up(map[cur][0], x-1);
    }
    
    //X칸 아래로 가기
    public static int down(int cur, int x) {
        if(x==0) return cur;
        if(map.length<=map[cur][2]) return cur;
        return down(map[cur][2], x-1);
    }
    
    //현재 정보 삭제하기
    public static int remove(int cur) {
        stack.add(cur);
        
        int pre = map[cur][0];
        int next = map[cur][2];
        
        if(0<=pre) map[pre][2]=map[cur][2];
        if(next<map.length) map[next][0]=map[cur][0];
        
        int k = 0;
        
        if(next<map.length) k=next;
        else k=pre;

        return k;
    }
    
    //삭제 정보 복구하기
    public static void restore() {
        int cur = stack.pop();
        
        int pre = map[cur][0];
        int next = map[cur][2];
        
        if(0<=pre) map[pre][2]=cur;
        if(next<map.length) map[next][0]=cur;
    }
}

//System.out.println("tmp : " +tmp);      
//System.out.println("삭제 후 인덱스 : " +k);
//System.out.println("k :" +k+ " > ch : " +ch);