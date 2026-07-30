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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDia(root);
        return max;
    }

    private int findDia(TreeNode node){
        if(node==null) return -1;

        int left=findDia(node.left);
        int right=findDia(node.right);
        max=Math.max(max,left+right+2);
        return Math.max(left,right)+1;
    }
}
