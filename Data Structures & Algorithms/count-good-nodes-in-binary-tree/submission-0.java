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
    public int goodNodes(TreeNode root) {
        return findGood(root,Integer.MIN_VALUE);
    }

    private int findGood(TreeNode node,int max){
        if(node==null) return 0;
        int count=0;
        if(node.val>=max){
            System.out.println("Enter :"+max+" "+node.val);
            count++;
            max=Math.max(max,node.val);
        }
        count=count+findGood(node.left,max);
        count=count+findGood(node.right,max);
        return count;
    }
}
