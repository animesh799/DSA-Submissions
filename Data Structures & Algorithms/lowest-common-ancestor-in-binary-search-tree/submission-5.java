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
       
       if(p.val<q.val){
        findLCA(root,p,q);
       }else{
        findLCA(root,q,p);
       }

        

        return result;
    }

    private void findLCA(TreeNode root, TreeNode p, TreeNode q){

        if(root==null) return;

        if(p.val<root.val&&q.val<root.val){
            findLCA(root.left,p,q);
        }

        if(p.val>root.val&&q.val>root.val){
            findLCA(root.right,p,q);
        }

        if((p.val<root.val&&root==q)||(p==root&&root.val<q.val)||(p.val<root.val&&q.val>root.val)){
            result=root;
        }

        return;

    }
}
