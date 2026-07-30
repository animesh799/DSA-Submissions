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
    boolean isBal=true;
    public boolean isBalanced(TreeNode root) {
        return findBal(root)!=-1;
        
    }

    private int findBal(TreeNode node){
        if(node==null) return 0;
        int left=findBal(node.left);
        if(left==-1) return -1;
        int right=findBal(node.right);
        if(right==-1) return -1;
        if(((int)Math.abs(left-right))>1) return -1;
        return Math.max(left,right)+1;
    }
}
