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
    public boolean hasCycle(ListNode head) {
       
       if(head==null||head.next==null){
        return false;
       }

        ListNode slow=head.next;
        ListNode fast=head.next.next;

        while(fast!=null&&fast.next!=null&&slow!=null){
            if(fast==slow){
                System.out.println("Value: "+fast.val);
                return true;
            } 
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
