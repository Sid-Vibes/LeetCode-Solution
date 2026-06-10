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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode last = head;
        if(head==null){
            return head;
        }
        int n=1;
        while(last.next!=null){
            n++;
            last=last.next;
        }
        ListNode l = head;
        k = k%n;
        if(k==0){
            return head;
        }
        int count = 1;
        while(count!=(n-k)){
            count++;
            l=l.next;
        }
        ListNode res = l.next;
        l.next=null;
        last.next=head;
        
        return res;
    }
}
