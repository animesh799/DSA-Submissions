class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return decode(0,s,new StringBuilder(),dp);
        
    }

    private int decode(int idx,String s,StringBuilder sb,int dp[]){
        if(idx==s.length()){
            return 1;
        }

        if(dp[idx]!=-1) return dp[idx];

        char ch =s.charAt(idx);  
        if((ch-'0'==0)){
            return 0;
        }


        int ways=0;
        //one digit
        ways=ways+decode(idx+1,s,new StringBuilder(),dp);
        

     //two digit

     if((idx+1)<s.length()){
        int num=(ch-'0')*10+(s.charAt(idx+1)-'0');
        if(num<27){
            ways=ways+decode(idx+2,s,sb,dp);
        }
     }

        return dp[idx]=ways;
        
    }
}
