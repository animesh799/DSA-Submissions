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
    public ListNode mergeKLists(ListNode[] lists) {
      ListNode head=new ListNode(-1);
      ListNode merged=null;
      for(int i=0;i<lists.length;i++){
        merged=mergeList(merged,lists[i],head);
      }
      return merged;
    }

    private ListNode mergeList(ListNode head1,ListNode head2,ListNode head3){
        ListNode temp1=head1;
        ListNode temp2=head2;
        ListNode temp3=head3;

        while(temp1!=null&&temp2!=null){
            if(temp1.val<temp2.val){
                temp3.next=temp1;
                temp3=temp3.next;
                temp1=temp1.next;
                temp3.next=null;
            }else{
                temp3.next=temp2;
                temp3=temp3.next;
                temp2=temp2.next;
                temp3.next=null;
            }
        }

        while(temp1!=null){
            temp3.next=temp1;
            temp3=temp3.next;
            temp1=temp1.next;
            temp3.next=null;
        }

        while(temp2!=null){
            temp3.next=temp2;
            temp3=temp3.next;
            temp2=temp2.next;
            temp3.next=null;
        }

        return head3.next;
    }
}
