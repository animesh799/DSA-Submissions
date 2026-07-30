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

        // --------------------------------------------------
        // Step 1 : Find the length of the linked list.
        // We only reverse complete groups of size k.
        // Example:
        // length = 8, k = 3
        // Only first 6 nodes will be reversed.
        // Remaining 2 nodes stay as they are.
        // --------------------------------------------------
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // Number of complete groups.
        int partition = len / k;

        // If even one complete group doesn't exist,
        // return the original list.
        if (partition == 0)
            return head;

        // curr -> beginning of current group
        // prev -> tail of previously reversed group
        // next -> first node of next group
        // newHead -> final head after first reversal
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode newHead = null;

        // Process every complete group.
        for (int i = 1; i <= partition; i++) {

            // -----------------------------------------
            // p1 = first node of current group
            // p2 = last node of current group
            //
            // Example:
            // 1 -> 2 -> 3 -> 4 -> 5
            // k = 3
            //
            // p1 = 1
            // p2 = 3
            // -----------------------------------------
            ListNode p1 = curr;
            ListNode p2 = curr;

            int count = 1;

            while (p2 != null && count != k) {
                p2 = p2.next;
                count++;
            }

            // Save the beginning of the next group
            // before reversing the current one.
            next = p2.next;

            // Reverse current group.
            reverse(p1, p2);

            // -----------------------------------------
            // Connect previous reversed group
            // with current reversed group.
            //
            // First iteration:
            // newHead becomes the last node (p2)
            // because it becomes the new head
            // after reversal.
            // -----------------------------------------
            if (prev == null) {
                newHead = p2;
            } else {
                prev.next = p2;
            }

            // -----------------------------------------
            // p1 becomes the tail after reversal.
            // Connect it with the remaining list.
            // -----------------------------------------
            p1.next = next;

            // Prepare for next iteration.
            curr = next;
            prev = p1;
        }

        return newHead;
    }

    // --------------------------------------------------
    // Reverse the linked list from p3 to p4.
    //
    // Example:
    // 1 -> 2 -> 3
    //
    // becomes
    //
    // 3 -> 2 -> 1
    //
    // NOTE:
    // Before calling this function, caller has
    // already stored p4.next in "next".
    // Hence it is safe to disconnect p4.
    // --------------------------------------------------
    private void reverse(ListNode p3, ListNode p4) {

        // Break the group from remaining list.
        p4.next = null;

        ListNode current = p3;
        ListNode prev = null;

        // Standard linked list reversal.
        while (current != null) {

            ListNode next = current.next;

            current.next = prev;

            prev = current;

            current = next;
        }
    }
}