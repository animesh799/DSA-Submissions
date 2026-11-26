class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

       int len=strs.length;

       Map<String,List<String>> map=new HashMap<>();

       for(int i=0;i<len;i++){

        int freq[]=new int[26];

        String s=strs[i];

        for(int j=0;j<s.length();j++){
         char ch=s.charAt(j);
         freq[ch-'a']++;
        }

        String key=Arrays.toString(freq);

        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
            
        }

        map.get(key).add(s);



       }

       List<List<String>> result=new ArrayList<>();
       
       for(String key:map.keySet()){
        result.add(map.get(key));
       }

    //   System.out.println(map);

       return result;
       
        
    }
}
