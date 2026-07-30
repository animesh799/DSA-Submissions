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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) return true;
        return findSubTree(root,subRoot)==1;

    }

    private int findSubTree(TreeNode root,TreeNode subRoot){
        if(root==null) return 0;
        int left=findSubTree(root.left,subRoot);
        if(left==1) return 1;
        int right=findSubTree(root.right,subRoot);
        if(right==1) return 1;
        boolean flag=false;
        if(root.val==subRoot.val){
            flag=equateTree(root,subRoot);
        }
        return flag?1:0;
    }

    private boolean equateTree(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1==null||node2==null) return false;
        if(node1.val!=node2.val) return false;
        return equateTree(node1.left,node2.left)&&equateTree(node1.right,node2.right);
    }
}
