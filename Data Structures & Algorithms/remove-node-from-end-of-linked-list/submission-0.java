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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      int len=0;
      ListNode temp=head;
      while(temp!=null){
        len++;
        temp=temp.next;
      }
      int target_node=len-n;
      if(target_node==0){
        head=head.next;
        return head;
      }
      
      int count=0;
      temp=head;
      System.out.println(target_node);
      while(temp!=null){
        count++;
        if(count==target_node){
            temp.next=temp.next.next;
            break;
        }
        temp=temp.next;
      }
      return head;
    }
}
