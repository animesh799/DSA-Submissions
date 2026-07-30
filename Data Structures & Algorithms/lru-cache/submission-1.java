class LRUCache {
    int cap=0,size=0;
    Map<Integer,Node> map;
    Node head,tail;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.cap=capacity;
        head=new Node(null,null,-1,-1);
        tail=new Node(null,null,-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        //return the -1 if key is absent
        if(map.get(key)==null){
            return -1;
        }

        //update the recency of the key
        Node node=map.get(key);
        
        if(node!=head){
            Node prevNode=node.prev;
            Node nextNode=node.next;

            prevNode.next=nextNode;
            nextNode.prev=prevNode;


            nextNode=head.next;
            head.next=node;
            node.prev=head;
            node.next=nextNode;
            nextNode.prev=node;
        }

        //return the key if present
        return node.value;
        
        
    }
    
    public void put(int key, int value) {
        //cehck the size of the list
        if(map.containsKey(key)){
           Node node=map.get(key);
           node.value=value;
           deleteNode(node);
           updateHead(node);
        }else{

          if(size==cap){
            Node prevNode=tail.prev;
            deleteNode(prevNode);
            map.remove(prevNode.key);
        }else{
           size++;
        }
        Node node=new Node(null,null,key,value);
        map.put(key,node);
        updateHead(node);
        
        }


    }

    private void deleteNode(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }

    private void updateHead(Node node){
        Node nextNode=head.next;
        head.next=node;
        node.prev=head;
        node.next=nextNode;
        nextNode.prev=node;
    }

    class Node{
        Node prev,next;
        int key,value;
        public Node(Node prev,Node next,int key,int val){
          this.prev=prev;
          this.next=next;
          this.key=key;
          this.value=val;
        }
    }
}
