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
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root,p,q);

        return result;
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q){

        if(root==null) return false;

        

        boolean left=findLCA(root.left,p,q);
        boolean right=findLCA(root.right,p,q);

        if(left&&right){
          result=root;
          return false;
        }

        if(left&&(root==p||root==q)){
          result=root;
          return false;
        }

        if(right&&(root==p||root==q)){
          result=root;
          return false;
        }


        if(root==p||root==q||left||right) return true;

        return false;



    }
}
