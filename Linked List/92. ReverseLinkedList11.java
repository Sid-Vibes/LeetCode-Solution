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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null){
            return null;
        }
        if(left==right){
            return head;
        }
        int pos = 1;
        ListNode before = null;
        ListNode t = head;
        while(t!=null){
            if(pos<left){
               before = t;
               t=t.next;
               pos++;
               continue;
            }
            int times = right-left+1;
            ListNode prev = null;
            ListNode curr = t;
            while(times>0){
                ListNode after = curr.next;
                curr.next = prev;
                prev = curr;
                curr = after;
                times--;
            }
            t.next = curr;
            if(before!=null){
                before.next = prev;
                return head;
            }
             return prev;
        }
         return head;
    }
}
