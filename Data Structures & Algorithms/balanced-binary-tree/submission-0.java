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
        findBal(root);
        return isBal;
    }

    private int findBal(TreeNode node){
        if(node==null) return 0;
        int left=findBal(node.left);
        int right=findBal(node.right);
        isBal=isBal&&(((int)Math.abs(left-right))<=1);
        return Math.max(left,right)+1;
    }
}
