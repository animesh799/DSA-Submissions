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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return findSameTree(p,q)!=-1;
    }

    private int findSameTree(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return 0;
        if((node1==null&&node2!=null)||(node1!=null&&node2==null)) return -1;

        int left=findSameTree(node1.left,node2.left);
        if(left==-1) return -1;
        int right=findSameTree(node1.right,node2.right);
        if(right==-1) return -1;
        return node1.val==node2.val?0:-1;
    }
}
