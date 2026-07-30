class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int arry1[]=new int[26];
        int arry2[]=new int[26];

        int l1=s1.length(),l2=s2.length();

        if(l2<l1) return false;

        for(int i=0;i<l1;i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            arry1[ch1-'a']++;
            arry2[ch2-'a']++;
        }

        for(int i=0;i<26;i++){
            System.out.print(" "+arry1[i]+" ");
           
        }
 System.out.println(" ");
        for(int i=0;i<26;i++){
            System.out.print(" "+arry2[i]+" ");
        }

        int p1=0,p2=l1-1;

        while(p2<l2){
            boolean isValid=validate(arry1,arry2);
            if(isValid){
                return true;
            }
            p2++;
            
            if(p2>=l2) break;
            char ch1=s2.charAt(p2);
            char ch2=s2.charAt(p1);
            arry2[ch1-'a']++;
            arry2[ch2-'a']--;
            p1++;
        }
        return false;
        
    }

    private boolean validate(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
