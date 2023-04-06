import java.util.*;
import java.util.Scanner;
 
public class Solution {
     
    static int n, k, result, depth;
    static int[] r, c;
    static int[][] map;
    static boolean[][] isvisited;
    static List<int[]> peak;
    static Queue<int[]> queue;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int t=0; t<T; t++) {
             
            //배열 크기 입력받기
            n = sc.nextInt();
             
            //최대 공사 가능 깊이
            k = sc.nextInt();
             
            //지도 배열 생성 및 값 입력받기
            map = new int[n][n];
            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map.length; j++) {
                    map[i][j]=sc.nextInt();
                }
            }
             
            //사방 탐색 배열
            r = new int[] {0, 1, 0, -1};
            c = new int[] {1, 0, -1, 0};
             
            //가장 높은 봉우리 좌표 배열
            peak = new ArrayList();
             
            //가장 높은 봉우리 높이찾기
            int max=0;
            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map.length; j++) {
                    if(max<map[i][j]) { max=map[i][j];}
                }
            }
             
            //가장 높은 봉우리 개수 찾기
            int count=0;
            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map.length; j++) {
                    if(max==map[i][j]) peak.add(new int[] {i, j});
                }
            }
             
            //드디어 BFS 실행!
            result=0;
            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map.length; j++) {
                    BFS(new int[] {i, j});                  
                }
            }
             
            System.out.printf("#%d %d\n", (t+1), result);
        }
    }
     
    public static void BFS( int[] location) {
         
        //지도 배열 복사
        int[][] tmpMap = new int[n][n];
        for(int i=0; i<tmpMap.length; i++) {
            tmpMap[i]=map[i].clone();
        }
         
        //임시 지도에서 봉우리 깍기
        int mowR = location[0];
        int mowC = location[1];
         
        //최대 k까지 깍을 수 있으므로 1~k를 깍을 수 있다.
        for(int t1=1; t1<=k; t1++) {
             
            tmpMap[mowR][mowC]=map[mowR][mowC]-t1;
             
            //방문 체크 배열 > 어짜피 값이 작아야만 갈 수 있으므로 이미 방문한 곳은 가지 못한다! (생략 가능)
            isvisited = new boolean[n][n];
             
            //큐 생성
            queue = new LinkedList();
            for(int t2=0; t2<peak.size(); t2++) {
                 
                int[] tmp = peak.get(t2);
                depth=0;                                        //등산로의 길이 0으로 초기화
                queue.offer(new int[] {tmp[0], tmp[1], 1});     //시작 좌표 큐에 넣기
//              System.out.println("BFS 시작 좌표 : " +tmp[0]+ " " +tmp[1]);
                 
                //반복 시작!
                while(!queue.isEmpty()) {
                     
                    //현재 좌표
                    int[] curr = queue.poll();
                     
                    int i = curr[0];
                    int j = curr[1];
                    depth = curr[2];
                     
                    //사방탐색
                    for(int k=0; k<4; k++) {
                        int dr = i+r[k];
                        int dc = j+c[k];
                         
                        //조건 확인하기
                        if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
//                  if(isvisited[dr][dc]) continue;
                        if(tmpMap[i][j]<=tmpMap[dr][dc]) continue;
                         
                        //조건에 다 맞으면
                        queue.offer(new int[] {dr, dc, depth+1});
//                  System.out.println("dr : " +dr+ ", dc : " +dc+ ", value : " +tmpMap[dr][dc]+ ", depth : "+depth);
                    }
                }
                 
                //반복문 끝났으면, 가장 값이 큰 등산로 찾기
                result=Math.max(result, depth);
                 
            }
        }
    }
}