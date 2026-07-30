/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        //find the length of ll
        ListNode node=head;
        int len=0;
        while(node!=null){
            len++;
            node=node.next;
        }
        //find mid
        int mid=len/2;
        //break the ll
        int curr=0;
        node=head;
        ListNode head2=null;
        while(node!=null){
            curr++;
            if(curr==mid){
             head2=node.next;
             node.next=null;
             break;
            }
            node=node.next;
        }
       
       //reverse second ll
       node=head2;
       ListNode prev=null;
       while(node!=null){
        ListNode temp=node.next;
        node.next=prev;
        prev=node;
        node=temp;
       }

       head2=prev;

        //traverse and connect ne by one

        ListNode temp1=head;
        ListNode temp2=head2;
        ListNode dummy=new ListNode(-1,null);
        ListNode temp3=dummy;

        while(temp1!=null||temp2!=null){
            if(temp1!=null){
          temp3.next=temp1;
          temp3 =temp3.next;
          temp1=temp1.next;
            }

if(temp2!=null){
         temp3.next=temp2;
          temp3=temp3.next;
          temp2=temp2.next;
}
 

        }
        
    }
}
