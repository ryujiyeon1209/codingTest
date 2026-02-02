class Solution {
    public String solution(String code) {
        String answer = "";
        
        int mode = 0;
        
        for(int i=0; i<code.length(); i++) {
            char ch = code.charAt(i);
            
            if(mode==0 && ch!='1' && (i%2==0))  answer+=ch;
            else if(mode==0 && ch=='1') mode=1;
            else if(mode==1 && ch!='1' && (i%2!=0)) answer+=ch;
            else if(mode==1 && ch=='1') mode=0;         
        }
        
        if(answer.equals("")) return "EMPTY";
        return answer;
    }
}