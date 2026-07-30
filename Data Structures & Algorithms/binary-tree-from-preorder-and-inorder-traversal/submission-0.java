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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size=preorder.length;
        return constructTree(0,size-1,preorder,0,size-1,inorder);
    }

    private TreeNode constructTree(int startPre,int endPre,int[] preorder,int startInord,int endInord,int[] inorder){
        if(startInord>endInord||startPre>endPre) return null;
        int value=preorder[startPre];
        TreeNode node=new TreeNode(value);
        int idx=-1;
        for(int i=startInord;i<=endInord;i++){
            if(inorder[i]==value){
              idx=i;
              break;
            }
        }
        int leftCount=idx-startInord;
        TreeNode left=constructTree(startPre+1,startPre+leftCount,preorder,startInord,idx-1,inorder);
        node.left=left;
        TreeNode right=constructTree(startPre+1+leftCount,endPre,preorder,idx+1,endInord,inorder);
        node.right=right;
        return node;

    }
}
