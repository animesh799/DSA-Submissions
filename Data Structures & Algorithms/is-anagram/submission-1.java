class Solution {
    public boolean isAnagram(String s, String t) {

        int[] s1=new int[26];
        int[] s2=new int[26];

        if(s.length()!=t.length()) return false;

        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            s1[c1-'a']++;
            s2[c2-'a']++;
        }

        for(int i=0;i<26;i++){
            if(s1[i]!=s2[i]) return false;
        }
        return true;

    }
}
