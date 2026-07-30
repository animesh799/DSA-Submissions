class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int p1=0,p2=1,p3=nums.length-1;
        int num=0;
        while(p1<p2&&p2<p3&&p1<nums.length){
            
            while(p2<p3){
                int sum=nums[p1]+nums[p2]+nums[p3];
                System.out.println("Sum :"+sum+" nums[p1] :"+nums[p1]+" nums[p2] :"+nums[p2]+" nums[p3] :"+nums[p3]);
                if(sum==0){
                    List<Integer> list =new ArrayList<>();
                    list.add(nums[p1]);
                    list.add(nums[p2]);
                    list.add(nums[p3]);
                    result.add(list);
                    num=nums[p2];
                    while(p2<nums.length&&nums[p2]==num) p2++;
                    num=nums[p3];
                    while(p3>=0&&nums[p3]==num) p3--;
                }else if(sum<0){
                    p2++;
                }else{
                    p3--;
                }
            }
            num=nums[p1];
            while(p1<nums.length&&nums[p1]==num) p1++;
            p2=p1+1;p3=nums.length-1;
        }

        return result;
        
    }
}
