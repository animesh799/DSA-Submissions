/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
         
         Map<Node,Node> map=new HashMap<>();

         return cloneDFS(node,map);
    }

    private Node cloneDFS(Node node,Map<Node,Node> map){

        if(map.containsKey(node)){
            return map.get(node);
        }


        Node newNode=new Node(node.val);
        map.put(node,newNode);


        for(int i =0;i<node.neighbors.size();i++){
            Node neb=node.neighbors.get(i);
            newNode.neighbors.add(cloneDFS(neb,map));
        }
        return newNode;

    }
}