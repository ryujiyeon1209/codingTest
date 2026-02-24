class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        int min = arr.length; 
        int max = -1;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==2 && min==arr.length) min = i;
            if(arr[i]==2 && min!=arr.length) max = i;
        }
        
        if(min==arr.length) return new int[] {-1};
        
        answer = new int[max-min+1];
        for(int i=0; i<answer.length; i++){
            answer[i] = arr[min++];
        }
        
        return answer;
    }
}