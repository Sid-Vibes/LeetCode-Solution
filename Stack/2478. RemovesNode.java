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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode>stack=new ArrayDeque<>();
        ListNode list = head;
        ListNode start = null;
        
        while(list!=null){
           
           while(!stack.isEmpty() && list.val>stack.peek().val){
                stack.pop();
            }
            stack.push(list);
            list = list.next;
        }
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next = start;
            start = node;
        }
        return start;
    }
}
