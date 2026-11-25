class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);

        int p1=0,p2=1,p3=nums.length-1;

    //    printArray(nums);


        while(p1<p2&&p1<nums.length){
            int v1=nums[p1];
            p2=p1+1;
            p3=nums.length-1;

            while(p2<p3){
                int sum=nums[p1]+nums[p2]+nums[p3];

                int v2=nums[p2];
                int v3=nums[p3];

              //  System.out.println("v1 :"+v1+" v2:"+v2+" v3:"+v3);



                if(sum==0){

                result.add(List.of(nums[p1],nums[p2],nums[p3]));
                while(p2<nums.length&&v2==nums[p2]){
                  p2++;
                }

                while(p3>=0&&v3==nums[p3]){
                  p3--;
                }

                }else if(sum>0){
                    p3--;
                }else{
                    p2++;
                }

            }

                while(p1<nums.length&&v1==nums[p1]){
                  p1++;
                }
        }

        return result;
        
    }

    public void printArray(int[] arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}
}
