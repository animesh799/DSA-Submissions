class Solution {
    public String minWindow(String s, String t) {

        int arry1[]=new int[58];
        int arry2[]=new int[58];
        int l1=t.length(),l2=s.length();

        if(l2<l1) return "";

        for(int i=0;i<l1;i++){
            char ch1=t.charAt(i);
            arry1[ch1-'A']++;
        }
        int p1=0,p2=0;
        int min=Integer.MAX_VALUE;
        String result="";

        for(int i=0;i<26;i++){
          //  System.out.print(" "+arry1[i]+" ");
           
        }
        int prev=-1;

        while(p2<l2&&p2>=p1){
         //   System.out.print("ENTER");
         if(prev!=p2){
                char ch1=s.charAt(p2);
                arry2[ch1-'A']++;
                prev=p2;
         }


            boolean isValid=validate(arry1,arry2);

            if(isValid){
                System.out.print("ENTER");
                if((p2-p1+1)<min){
                  System.out.println("p1 :"+p1+" : p2 :"+p2);  
                 min=Math.min(p2-p1+1,min);
                 result=s.substring(p1,p2+1);
                }
                char ch2=s.charAt(p1);
                arry2[ch2-'A']--;
                p1++;
            }else{
                p2++;
            }

        }
        return result;
        
    }

    private boolean validate(int[] arry1,int[] arry2){
        for(int i=0;i<58;i++){
            if(arry1[i]!=0&&arry2[i]<arry1[i]){
                return false;
            }
        }
        return true;
    }
}
