class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        int arr1[]=new int[26];
        int arr2[]=new int[26];

        for(int i=0;i<strs.length;i++){
            if(visited.contains(i)) continue;
            List<String> anagramSet=new ArrayList<>();
            visited.add(i);
            anagramSet.add(strs[i]);
            for(int j=i+1;j<strs.length;j++){
            if(visited.contains(j)) continue;
               if(compare(strs[i],strs[j],arr1,arr2)){
                visited.add(j);
                anagramSet.add(strs[j]);
               }
            }
            res.add(anagramSet);
        }
        return res;
    }

    private boolean compare(String a,String b,int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            arr1[i]=0;
            arr2[i]=0;
        }
        for(int i=0;i<a.length();i++){
            char ch=a.charAt(i);
            arr1[ch-'a']++;
        }

        for(int i=0;i<b.length();i++){
            char ch=b.charAt(i);
            arr2[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }   
        }
        return true;
    }
}
