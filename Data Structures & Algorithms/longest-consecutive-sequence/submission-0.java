class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> freqMap=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int prevFreq=0;
            if(freqMap.get(num-1)!=null){
                prevFreq=freqMap.get(num-1);
            }
            freqMap.put(num,prevFreq+1);
        }

        int max=0;
        for(int key:freqMap.keySet()){
            int val=freqMap.get(key);
            max=Math.max(max,val);
        }

        return max;

    }
}
