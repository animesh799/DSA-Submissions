class Solution {
    public List<Integer> partitionLabels(String s) {

        Map<Character,Integer> map=new HashMap<>();
        int len=s.length();

        for(int i=0;i<len;i++){
            Character ch=s.charAt(i);
            map.put(ch,i);
        }

        System.out.println(map);

        int start=0,end=0;
        List<Integer> res=new ArrayList<>();

        while(end<len){
            end=map.get(s.charAt(start));
            for(int i=start;i<=end;i++){
                char ch=s.charAt(i);
                end=Math.max(end,map.get(ch));
            }
            res.add(end-start+1);
            start=end+1;
            end=start;
        }

        return res;
        
    }
}
