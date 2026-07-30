class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        

        Map<Integer,Integer> map=new HashMap<>();

        for(int i =0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }
            map.put(nums[i],map.get(nums[i])+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.freq,b.freq));

        for(int key:map.keySet()){
            if(pq.size()<k){
                pq.add(new Pair(key,map.get(key)));
            }else{
                Pair peek=pq.peek();
                if(peek.freq<map.get(key)){
                    pq.poll();
                    pq.add(new Pair(key,map.get(key)));
                }else{
                    // leave
                }
            }

        }

        int ans[] =new int[k];

        for(int i=0;i<k;i++){
            ans[i]=pq.poll().key;
        }

        return ans;
    }

    class Pair{
        int key,freq;
        Pair(int key,int freq){
            this.key=key;
            this.freq=freq;
        }
    }
}
