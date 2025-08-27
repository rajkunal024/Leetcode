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
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz=0;
        ListNode curr = head;
        while(curr != null)
        {
            curr = curr.next;
            sz++;
        }

        if(n==sz) {
            head=head.next;
            return head;
        }

        int i = 1;
        int iToFind = sz - n;
        ListNode prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}
