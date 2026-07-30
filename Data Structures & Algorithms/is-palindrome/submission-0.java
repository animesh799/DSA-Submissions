class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int p1=0,p2=s.length()-1;
        while(p1<p2){
            char ch1=s.charAt(p1);
            char ch2=s.charAt(p2);
            System.out.println("Char :"+ch1);
            System.out.println("Char :"+ch2);
            if(!checkAlpha(ch1)){
                p1++;
                continue;
            }

            if(!checkAlpha(ch2)){
                p2--;
                continue;
            }
            if(ch1!=ch2){
                return false;
            }

            p1++;
            p2--;

           
        }
        return true;
    }

    private boolean checkAlpha(char c){
       if((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9')){
        return true;
       }
       return false;
    }
}
