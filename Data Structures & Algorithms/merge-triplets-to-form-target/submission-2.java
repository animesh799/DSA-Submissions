class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] curr=new int[3];
            // curr[0]=triplets[0][0];
            // curr[1]=triplets[0][1];
            // curr[2]=triplets[0][2];

        int len=triplets.length;

        for(int i=0;i<len;i++){
            int[] triplet=triplets[i];
            int max1=Math.max(curr[0],triplet[0]);
            int max2=Math.max(curr[1],triplet[1]);
            int max3=Math.max(curr[2],triplet[2]);
            if(max1<=target[0]&&max2<=target[1]&&max3<=target[2]){
                curr[0]=max1;
                curr[1]=max2;
                curr[2]=max3;
            }
        }
        if(curr[0]==target[0]&&curr[1]==target[1]&&curr[2]==target[2]) return true;
        return false;
        
    }


}
