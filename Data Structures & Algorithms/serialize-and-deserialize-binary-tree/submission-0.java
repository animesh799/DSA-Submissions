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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root!=null){
            queue.add(root);
        }
        StringBuffer sb=new StringBuffer();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
               sb.append(node.val);
               sb.append("#");
            }else{
               sb.append("N");
               sb.append("#");
            }        
               
            if(node!=null) queue.add(node.left);
            if(node!=null) queue.add(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(data.length()==0) return null;
        int start=0;
        String rootString[]=extractNode(start,data);
        TreeNode rootNode=new TreeNode(Integer.parseInt(rootString[0]));
        start=Integer.parseInt(rootString[1]);
        queue.add(rootNode);

        while(!queue.isEmpty()){
              
              //take out the node from queue
              TreeNode node=queue.poll();


              //take out the two elements from the string left and right
               String[] node_pos=extractNode(start,data);
               
               if(node_pos[0].equals("N")){
                  node.left=null;
               }else{
                  TreeNode left=new TreeNode(Integer.parseInt(node_pos[0]));
                  node.left=left;
                  queue.add(left);
               }

               start=Integer.parseInt(node_pos[1]);
               node_pos=extractNode(start,data);

              if(node_pos[0].equals("N")){
                  node.right=null;
               }else{
                  TreeNode right=new TreeNode(Integer.parseInt(node_pos[0]));
                  node.right=right;
                  queue.add(right);
               }

               start=Integer.parseInt(node_pos[1]);
              //put the left and right in the node taken out from queue

              //if the left and right are not null put them back in the quue


        }
        

        
       return rootNode;
    }

    private String[] extractNode(int start,String s){
        StringBuffer sb=new StringBuffer();
        int idx=-1;
        for(int i=start;i<s.length();i++){
             char ch=s.charAt(i);
             if(ch=='#'){
               idx=i+1;
               break;
             } 
             sb.append(ch);
        }

        return new String[]{sb.toString(),idx+""};
    }
}
