class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set=new HashSet<>();

        int ptr1=0,ptr2=0,len=s.length(),ans=0;

        while(ptr1<len){
            char ch=s.charAt(ptr1);
            if(!set.add(ch)){
            ans=Math.max(ans,set.size());
            while(s.charAt(ptr2)!=ch){
                set.remove(s.charAt(ptr2));
                ptr2++;
            }
            ptr2++;
            }
            ptr1++;
        }

        ans=Math.max(ans,set.size());

        return ans;
        
    }
}
