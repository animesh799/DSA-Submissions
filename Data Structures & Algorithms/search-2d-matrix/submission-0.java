class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length,col=matrix[0].length;
        int start=0,end=rows*col-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            int element=matrix[mid/col][mid%col];
            if(element==target){
                return true;
            }else if(element>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}
