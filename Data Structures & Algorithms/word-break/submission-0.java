class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> set=new HashSet<String>();
        int maxLen=0;
        for(int i=0;i<wordDict.size();i++){
             set.add(wordDict.get(i));
             maxLen=Math.max(maxLen,wordDict.get(i).length());
        }

        boolean dp[]=new boolean[n+1];

        dp[0]=true;

        for(int i=1;i<=n;i++){
               
               int currIdx=i-1;

               int currStringLen=1;

               while(currStringLen<=maxLen&&currIdx>=0){
                  String sub=s.substring(currIdx,i);

                  if(set.contains(sub)&&dp[currIdx]){
                     dp[i]=true;
                     break;
                  }


                  currIdx--;
                  currStringLen++;
               }

        }

        return dp[n];
        
    }
}
