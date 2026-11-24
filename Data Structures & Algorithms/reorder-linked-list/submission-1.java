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

        ListNode curr=head;


        //find mid

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        






        //get two halves

        ListNode head1=head;
        ListNode head2=slow.next;

        slow.next=null;

      //  System.out.println(head.val+" "+head2.val);



        //reverse second half

        ListNode temp=head2;
        ListNode prev=null;

        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }

        ListNode revHead=prev;

        ListNode curr1=head1;
        ListNode curr2=revHead;
        

        ListNode dummy=new ListNode(-1);

        ListNode curr3=dummy;

        


        while(curr1!=null&&curr2!=null){

            

            System.out.println("curr1 :"+curr1.val+" curr2:"+curr2.val+" curr3:"+curr3.val);


            ListNode next1=curr1.next;
            ListNode next2=curr2.next;

            curr3.next=curr1;
            curr3=curr3.next;
            curr3.next=curr2;
            curr3=curr3.next;
            curr1=next1;
            curr2=next2;
        }

        if(curr1!=null){
            curr3.next=curr1;
        }


        if(curr2!=null){
            curr3.next=curr2;
        }





        //combine two halves
        
    }
}
