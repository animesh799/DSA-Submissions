class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return lcs(text1,text2,0,0,dp);
        
    }

    private int lcs(String s1, String s2,int p1,int p2,int[][] dp){
        if(p1==s1.length()||p2==s2.length()){
            return 0;
        }
        if(dp[p1][p2]!=-1) return dp[p1][p2];
        char ch1=s1.charAt(p1);
        char ch2=s2.charAt(p2);
        int count=0;
        if(ch1==ch2){
            count=count+lcs(s1,s2,p1+1,p2+1,dp)+1;
        }else{
            count=Math.max(lcs(s1,s2,p1,p2+1,dp),lcs(s1,s2,p1+1,p2,dp));
        }
        return dp[p1][p2]=count;
    }
}
