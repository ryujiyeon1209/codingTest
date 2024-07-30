import java.util.*;

class Solution {

    static int answer;
    static int[] arr;
    static Set<Integer> set;
    static boolean[] isvisited, ischeck;
    static int[] select;
    
    public int solution(String numbers) {
        
        arr = new int[numbers.length()];
        for(int i=0; i<arr.length; i++){
            arr[i] = numbers.charAt(i)-'0';
        }
        
        set = new HashSet();
        
        ischeck = new boolean[10000000];
        check(9999999);
        
        for(int i=1; i<=arr.length; i++){
            select = new int[i];
            isvisited = new boolean[arr.length];
            subset(0);
        }
        
        
        return answer;
    }
    
    //순열
    public static void subset(int idx) {
        
        if(select.length<=idx) {
            
            String tmp = "";
            for(int i=0; i<select.length; i++){
                tmp+=select[i];
            }
            
            int num = 0;
            if(!tmp.equals("")) num=Integer.parseInt(tmp);
            else return;
            
            
            int size = set.size();
            set.add(num);
            if(set.size()==size) return;

            if(ischeck[num]) answer++;
            
            return;
        }
        
        for(int i=0; i<isvisited.length; i++){
            if(isvisited[i]) continue;
            
            isvisited[i]=true;
            select[idx]=arr[i];
            subset(idx+1);
                
            isvisited[i]=false;
        }
    }
    
    //소수인지 확인하는 메서드 : 에라토스테네스
    public static void check(int num) {
        
        for(int i=0; i<ischeck.length; i++){
            ischeck[i]=true;
        }
        
        ischeck[0]=false;
        ischeck[1]=false;
        
        for(int i=2; i<(int)Math.sqrt(num); i++){
            if(ischeck[i]) {
                for(int j=i*i; j<=num; j+=i){
                    ischeck[j]=false;
                }
            }
        }
    }
    
}