/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node temp=head;
        Node dummy=new Node(-1);
        Node temp2=dummy;
        while(temp!=null){
            Node copy=new Node(temp.val);
            map.put(temp,copy);
            temp2.next=copy;
            temp=temp.next;
            temp2=temp2.next;
        }
        System.out.println(map);
        temp=head;
        temp2=dummy.next;
        while(temp!=null){
            Node random=map.get(temp.random);
           temp2.random=random;
            temp2=temp2.next;
            temp=temp.next;
        }

        return dummy.next;
    }
}
