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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>list1=new ArrayList<>();
        List<TreeNode>list2=new ArrayList<>();

        findPath(root,p,list1);
        findPath(root,q,list2);

        for(int i=0;i<list1.size();i++){
           System.out.print(list1.get(i).val+" ");
        }
System.out.println(" ");
        for(int i=0;i<list2.size();i++){
           System.out.print(list2.get(i).val+" ");
        }
System.out.println(" ");
        for(int i=0;i<list1.size();i++){
           TreeNode node=list1.get(i);
           if(list2.contains(node)){
            return node;
           }
        }
        return null;
        
    }

    private boolean findPath(TreeNode root,TreeNode node,List<TreeNode> path){
        if(root==null){
          return false;
        }
        System.out.println("root: "+root.val+" node: "+node.val);
        if(root.val==node.val){
            System.out.println("got it!!! ");
            path.add(root);
          return true;
        } 

        boolean left=findPath(root.left,node,path);
        if(left){
            path.add(root);
            return true;
        }
        boolean right=findPath(root.right,node,path);

        if(right){
            path.add(root);
            return true;
        }

        return false;

    }
}
