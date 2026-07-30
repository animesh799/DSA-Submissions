class Solution {
    public int maxArea(int[] heights) {
        int result=0;
        int p1=0,p2=heights.length-1;
        while(p1<p2){
            int water=Math.min(heights[p1],heights[p2])*(p2-p1);
            result=Math.max(water,result);
            if(heights[p1]<heights[p2]){
                p1++;
            }else if(heights[p1]>heights[p2]){
                p2--;
            }else{
                p1++;
                p2--;
            }
        }
        return result;
    }
}
