class Solution {
    public int solution(String number) {
        
        String str = String.valueOf(number);
        int num = 0;
        
        for(char ch : str.toCharArray()){
            num+=(ch-'0');
        }
        
        return num%9;
    }
}