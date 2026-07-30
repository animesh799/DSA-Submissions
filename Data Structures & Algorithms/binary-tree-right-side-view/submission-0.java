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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            TreeNode node=queue.poll();
            res.add(node.val);
            if(node.right!=null) queue.add(node.right);
            if(node.left!=null) queue.add(node.left);
            for(int i=1;i<size;i++){
              node=queue.poll();
            if(node.right!=null) queue.add(node.right);
            if(node.left!=null) queue.add(node.left);
            }
        }
        return res;
    }
}
