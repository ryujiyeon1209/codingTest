class Solution {
    public int[] solution(int[] arr, int n) {
        
        int idx = 0;
        
        if(arr.length%2==0) idx = 1;
        else idx = 0;
        
        while(idx<arr.length) {
            arr[idx]+=n;
            idx+=2;
        }
        
        
        return arr;
    }
}