import java.util.*;

class Solution {
    
    static char[][] map;
    
    public int solution(String[] board) {
        int answer = 1;
        
        //2차원 배열로 수정
        map = new char[3][3];
        for(int i=0; i<board.length; i++){
            map[i] = board[i].toCharArray(); 
        }
        
        //1. 선공, 후궁 조건이 맞는지 확인
        int white = 0;
        int black = 0;
    
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j]=='O') white++;
                else if(map[i][j]=='X') black++;
            }
        }
        
        if(white<black || 2<=white-black) return 0;
        
        //2. 성공했음에도 게임을 진행했는지 확인
        int wflag = 0;
        int bflag = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j]=='O') {
                    wflag+=check(i, j, 'O');
                }
            }
        }
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j]=='X') {
                   bflag+=check(i, j, 'X');
                }
            }
        }
        
        if(1<bflag) answer = 0;
        if(0<wflag && white-black!=1) answer = 0;
        if(0<bflag && white-black!=0) answer = 0;
        
        
        return answer;
    }
    
    //틱택톡 성공했는지 확인
    public static int check(int x, int y, char ch){
        
        int count = 0;
        if(x+2<map.length && map[x+1][y]==ch && map[x+2][y]==ch) count+=1;
        if(y+2<map.length && map[x][y+1]==ch && map[x][y+2]==ch) count+=1;
        if(x+2<map.length && y+2<map.length
            && map[x+1][y+1]==ch && map[x+2][y+2]==ch) count+=1;
        if(x+2<map.length && y-2==0
            && map[x+1][y-1]==ch && map[x+2][y-2]==ch) count+=1;
        
        return count;
    }
    
    
}