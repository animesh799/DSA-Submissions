class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }

        int max=1;
        int maxStart=0,maxEnd=0;

        for(int i=2;i<=n;i++){


            for(int j=0;j<=n-i;j++){

                int start=j;
                int end=j+i-1;

                if(s.charAt(start)!=s.charAt(end)){
                    continue;
                }

                if(i==2){
                    dp[start][end]=true;
                }else{
                     dp[start][end]=dp[start+1][end-1];
                }

                

                if(dp[start][end]&&i>max){
                    maxStart=start;
                    max=i;
                }




            }

            




        }
        return s.substring(maxStart,maxStart+max);
        



    }

}
