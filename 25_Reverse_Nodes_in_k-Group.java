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
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        ListNode node = new ListNode();
        ListNode newHead = node;
        while(head!=null){
            if(stack.size()<k){
                stack.push(head.val);
            }else{
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
                stack = new Stack<>();
                stack.push(head.val);
            }
            head = head.next;
        }
        if(!stack.isEmpty()){
            if(stack.size()==k){
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
            }else{
                for(int k1:stack){
                list.add(k1);
            }
            }
        }
        for(Integer l:list){
            ListNode temp = new ListNode(l);
            node.next = temp;
            node = temp;
        }
        return newHead.next;
    }
}


/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]

*/
