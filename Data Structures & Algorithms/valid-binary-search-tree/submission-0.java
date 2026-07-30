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
    public boolean isValidBST(TreeNode root) {
        return validate(root,Integer.MIN_VALUE+1,Integer.MAX_VALUE-1);
    }

    private boolean validate(TreeNode node,int lb,int ub){
        if(node==null) return true;
        if(node.val<lb||node.val>ub) return false;
        return validate(node.left,lb,node.val-1)&&validate(node.right,node.val+1,ub);
    }
}
