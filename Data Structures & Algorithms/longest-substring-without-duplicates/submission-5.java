class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set=new HashSet<>();

        int result=0;

        int p1=0,p2=0;

        int len=s.length();

        while(p2<len){
         //   System.out.println("p1:"+p1+" p2:"+p2+" len:"+len);


            while(p2<len&&set.add(s.charAt(p2))){
                p2++;
            }

            if(p2==len) break;

            result =Math.max(result,set.size());

            char ch=s.charAt(p2);

            while(p1<p2&&s.charAt(p1)!=ch){
                set.remove(s.charAt(p1));
                p1++;
            }
            p1++;

            p2++;




            
        }

        result =Math.max(result,set.size());

        return result;
        
    }
}
