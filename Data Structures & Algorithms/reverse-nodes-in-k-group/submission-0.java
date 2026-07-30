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
    public ListNode reverseKGroup(ListNode head, int k) {
       
        ListNode temp=head;
        int len=0;
        
        while(temp!=null){
            len++;
            temp=temp.next;
        }

        int partition=len/k;
        ListNode curr=head;
        ListNode prev=null,next=null,newHead=null;
        for(int i=1;i<=partition;i++){

            ListNode p1=curr,p2=curr;
            int count=1;
            
            while(p2!=null&&count!=k){
                p2=p2.next;
                count++;
            }
            next=p2.next;

            reverse(p1,p2);

            if(prev==null){
                newHead=p2;
            }else{
                prev.next=p2;
            }

            p1.next=next;

            curr=next;
            prev=p1;




        }

 
       return newHead;
        
    }


    private void reverse(ListNode p3,ListNode p4){
        p4.next=null;
        ListNode current=p3;
        ListNode prev=null;

        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
    }
}
