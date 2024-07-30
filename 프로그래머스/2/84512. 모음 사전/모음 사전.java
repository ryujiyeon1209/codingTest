import java.util.*;

class Solution {

    static List<String> list;
    static char[] arr, select;
    
    public int solution(String word) {
        int answer = 0;
        
        //모음으로 만들 수 있는 모든 단어 확인
        arr = new char[] {'A', 'E', 'I', 'O', 'U'};
        list = new ArrayList();
        
        for(int i=1; i<=arr.length; i++){
            select = new char[i];
            permutation(0);
        }
        
        //사전순으로 정렬
        Collections.sort(list);
        
        //순서 확인
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)) answer=i+1;
        }
        
        return answer;
    }
    
    
    //중복 순열 메서드
    public static void permutation(int idx){
        
        if(select.length<=idx) {
            
            String str = "";
            for(int i=0; i<select.length; i++){
                str+=select[i];
            }
            
            list.add(str);
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            select[idx] = arr[i];
            permutation(idx+1);
        }
    }


}