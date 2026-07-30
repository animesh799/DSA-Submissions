class Solution {
    public int characterReplacement(String s, int k) {
        int p1=0,p2=0;

        int[] freqArray=new int[26];
        int result=0;
        int max=0;

        while(p1<=p2&&p2<s.length()){
            
            char ch=s.charAt(p2);
            freqArray[ch-'A']++;
            max=0;
            for(int i=0;i<26;i++){
                max=Math.max(max,freqArray[i]);
            }
            if((p2-p1+1-max)<=k){
                result=Math.max(result,p2-p1+1);
                p2++;
            }else{
                char ch2=s.charAt(p1);
                freqArray[ch2-'A']--;
                p1++;
                p2++;

            }
        }
        return result;
        
    }

    private boolean validate(int p1,int p2,String s,int k){
        int arry[]=new int[26];
        for(int i=p1;i<=p2;i++){
            char ch=s.charAt(i);
            arry[ch-'A']++;
        }

       Arrays.sort(arry);
       for(int i=0;i<arry.length-1;i++){
        if(arry[i]!=0){
            if(arry[i]>k){
                return false;

            }else {
                k=k-arry[i];
            }
        }
       }
       return true;
    }
}
