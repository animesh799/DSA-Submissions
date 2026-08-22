class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int len=hand.length;

        if(len%groupSize!=0) return false;

        Map<Integer,Integer> map=new HashMap<>();

        Arrays.sort(hand);

        for(int i=0;i<hand.length;i++){
            if(!map.containsKey(hand[i])){
                map.put(hand[i],0);
            }

            int freq=map.get(hand[i]);

            map.put(hand[i],freq+1);
        }

        System.out.println("map:"+map);

        for(int j=0;j<hand.length;j++){
            if(map.get(hand[j])==0) continue;

            int curr=hand[j];
            int freq=map.get(curr);
            map.put(curr,freq-1);

            for(int i=1;i<groupSize;i++){
                if(map.get(curr+1)!=null&&map.get(curr+1)>0){
                   freq=map.get(curr+1);
                   map.put(curr+1,freq-1);
                }else{
                    return false;
                }
                curr=curr+1;
            }

        }


        return true;
        
    }
}
