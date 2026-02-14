class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int i=0; i<queries.length; i++){      
            int idx1 = queries[i][0];
            int idx2 = queries[i][1];

            int arr1 = arr[idx1];
            int arr2 = arr[idx2];

            arr[idx1] = arr2;
            arr[idx2] = arr1;
        }
        
        return arr;
    }
}