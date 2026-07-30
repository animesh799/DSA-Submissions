class Solution {
    public int characterReplacement(String s, int k) {
        int p1=0,p2=0;

        int[] freqArray=new int[26];
        int result=0;

        while(p1<=p2&&p2<s.length()){

            boolean isValid=validate(p1,p2,s,k);
            if(isValid){
                result=Math.max(result,p2-p1+1);
                p2++;
            }else{
                p1++;
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
