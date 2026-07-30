/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxSum=Integer.MIN_VALUE+1;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode node){
        if(node==null) return 0;
        int left=findMax(node.left);
        int right=findMax(node.right);
        int nodeVal=node.val;
        int max=Math.max(nodeVal,nodeVal+left);
        max=Math.max(max,nodeVal+right);
        int sendUp=max;
        max=Math.max(max,nodeVal+right+left);
        maxSum=Math.max(maxSum,max);
        return sendUp;
    }
}
