class Solution {
    public boolean checkValidString(String s) {

        int len=s.length();
        int leftMax=0,leftMin=0;

        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                leftMax++;
                leftMin++;
            }else if(ch==')'){
                leftMax--;
                leftMin--;
                if(leftMax<0) return false;
                
            }else{
                leftMax++;
                leftMin--;
            }
            leftMin=Math.max(0,leftMin);
        }
        if(leftMin==0) return true;
        return false;
        
    }
}
