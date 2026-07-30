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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0,remainder=0;
        ListNode dummy=new ListNode(-1);
        ListNode temp3=dummy;
        while(temp1!=null&&temp2!=null){
           int sum=temp1.val+temp2.val+carry;
           remainder=sum%10;
           ListNode node=new ListNode(remainder);
           temp3.next=node;
           carry=sum/10;
           temp1=temp1.next;
           temp2=temp2.next;
           temp3=temp3.next;
        }

        while(temp1!=null){
            int sum=temp1.val+carry;
            remainder=sum%10;
            ListNode node=new ListNode(remainder);
            temp3.next=node;
            temp3=temp3.next;
            temp1=temp1.next;
            carry=sum/10;
        }


        while(temp2!=null){
            int sum=temp2.val+carry;
            remainder=sum%10;
            ListNode node=new ListNode(remainder);
            temp3.next=node;
            temp3=temp3.next;
            temp2=temp2.next;
        }

        if(carry!=0){
          ListNode node=new ListNode(carry);
          temp3.next=node; 
        }

        return dummy.next;
    }
}
