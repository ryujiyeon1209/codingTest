import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int startr = -1;
        int startc = -1;
        int endr = -1;
        int endc = -1;
        
        char[][] wallpapers = new char[wallpaper.length][wallpaper[0].length()];
        for(int i=0; i<wallpapers.length; i++){
            wallpapers[i] = wallpaper[i].toCharArray();
        }
        
        //r 찾기
        for(int i=0; i<wallpapers.length; i++){
            for(int j=0; j<wallpapers[i].length; j++){
                if(startr==-1 && wallpapers[i][j]=='#') {
                    startr=i;
                    endr=i;
                }
                
                else if(startr!=-1 && wallpapers[i][j]=='#') {
                    endr=i;
                }
            }
        }
        
        //c찾기
        for(int i=0; i<wallpapers[0].length; i++){
            for(int j=0; j<wallpapers.length; j++){
                if(startc==-1 && wallpapers[j][i]=='#') {
                    startc=i;
                    endc=i;
                }
                
                else if(startc!=-1 && wallpapers[j][i]=='#') {
                    endc=i;
                }
            }
        }
        
        int[] answer = {startr, startc, endr+1, endc+1};
        return answer;
    }
}