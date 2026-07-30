class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int leftMax[]=new int[len];
        int rightMax[]=new int[len];
        
        int left=0,right=0;
        for(int i=0;i<len;i++){
            leftMax[i]=left;
            left=Math.max(left,height[i]);
            rightMax[len-1-i]=right;
            right=Math.max(right,height[len-1-i]);
        }
        for(int i=0;i<len;i++){
            System.out.println("left :"+leftMax[i]+" right :"+rightMax[i]+" height :"+height[i]);
        }
        
        int sum=0;
        for(int i=0;i<len;i++){
            int water=Math.min(rightMax[i],leftMax[i])-height[i];
            if(water>0){
                sum=sum+water;
            }

        }

        return sum;
        
        
    }
}
