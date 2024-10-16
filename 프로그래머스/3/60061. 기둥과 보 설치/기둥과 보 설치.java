import java.util.*;

class Solution {
    
    static int[][] pmap, cmap;
    
    public int[][] solution(int n, int[][] build_frame) {

        //기둥 설치 배열
        pmap = new int[n+1][n+1];
        
        //기둥 설치 배열
        cmap = new int[n+1][n+1];
     
        
        //기둥과 보 설치
        for(int i=0; i<build_frame.length; i++){
            int c = build_frame[i][0];
            int r = build_frame[i][1];
            int type = build_frame[i][2];    // 0: 기둥, 1: 보
            int build = build_frame[i][3];   // 0: 삭제, 1: 설치
            
            //기둥 삭제라면
            if(build==0 && type==0) {
                pmap[r][c]=0;
                if(!remove()) pmap[r][c]=1;
            }
            
            //보 삭제라면
            if(build==0 && type==1) {
                cmap[r][c]=0;
                if(!remove()) cmap[r][c]=1;
            } 
                
            
            //기둥 설치라면 
            if(build==1 && type==0) {
                if(build_p(r, c)) pmap[r][c]=1;
            }
            
            //보 설치라면
            if(build==1 && type==1) {
                if(build_c(r, c)) cmap[r][c]=1;
            }
        }
        
        //기둥과 보 설치 
        int count = 0;
        for(int i=0; i<pmap.length; i++){
            for(int j=0; j<pmap[i].length; j++){
                if(pmap[i][j]==1) count++;
                if(cmap[i][j]==1) count++;
            }
        }

        
        int idx = 0;
        int[][] answer = new int[count][3];
        for(int i=0; i<pmap.length; i++){
            for(int j=0; j<pmap[i].length; j++){
                if(pmap[i][j]==1) {
                    answer[idx][0]=j;
                    answer[idx][1]=i;
                    answer[idx][2]=0;
                    idx++;
                }
                if(cmap[i][j]==1) {
                    answer[idx][0]=j;
                    answer[idx][1]=i;
                    answer[idx][2]=1;
                    idx++;
                }
            }
        }
        
        //정렬
        Arrays.sort(answer , new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0] && o1[1]==o2[1]) return o1[2]-o2[2];
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            } 
        });
        
        return answer;
    }
    
    //기둥 설치 확인
    public static boolean build_p(int r, int c) {
        
        //기둥이 바닥 위에 있기
        if(r==0) return true;
        
        //왼쪽에 보가 있기
        if(0<=c-1 && cmap[r][c-1]==1) return true;
        
        //오른쪽에 보가 있기
        if(cmap[r][c]==1) return true;
        
        //또 다른 기둥 위에 있기
        if(0<=r-1 && pmap[r-1][c]==1) return true;
        
        return false;
    }
    
    //보 설치 확인
    public static boolean build_c(int r, int c) {
        
        //왼쪽 아래에 기둥이 있기
        if(0<=r-1 && pmap[r-1][c]==1) return true;
        
        //오른쪽 아래 기둥이 있기
        if(0<=r-1 && c+1<pmap.length && pmap[r-1][c+1]==1) return true;
        
        //양 옆에 보가 있다면
        if(0<=c-1 && c+1<cmap.length && cmap[r][c-1]==1 && cmap[r][c+1]==1) return true;
        
        return false;
    }
    
    //삭제 확인
    public static boolean remove(){
        
        //현재 자리에 기둥이나 보가 있을 때, 유효성이 있는지
        for(int i=0; i<pmap.length; i++){
            for(int j=0; j<pmap[i].length; j++){
                if(pmap[i][j]==1 && !build_p(i, j)) return false;
                if(cmap[i][j]==1 && !build_c(i, j)) return false;   
            }
        }
            
        return true;

    }
}

// System.out.println("1"); 
// System.out.println("count : " +count);
// System.out.println(" r : " +r+", c : " +c+ " > " +cmap[r][c]);
// System.out.println(" r : " +r+", c : " +c+ " > " +pmap[r][c]);