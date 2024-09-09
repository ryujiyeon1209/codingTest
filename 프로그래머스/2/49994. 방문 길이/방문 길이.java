class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][][] map = new boolean[4][11][11];
        
        int r = 5;
        int c = 5;
        
        //계산하기
        char[] charr = dirs.toCharArray();
        for(int i=0; i<charr.length; i++){
            if(charr[i]=='U' && 0<=r-1) {
                if(!map[1][r-1][c] && !map[0][r][c]) answer++;
                map[0][r--][c]=true;
            }
            if(charr[i]=='D' && r+1<=10) {
                if(!map[0][r+1][c] && !map[1][r][c]) answer++;
                map[1][r++][c]=true;
            }
            if(charr[i]=='R' && c+1<=10) {
                if(!map[3][r][c+1] && !map[2][r][c]) answer++;
                map[2][r][c++]=true;
            }
            if(charr[i]=='L' && 0<=c-1) {
                if(!map[2][r][c-1] && !map[3][r][c]) answer++;
                map[3][r][c--]=true;
            }
        }
        
        return answer;
    }
}