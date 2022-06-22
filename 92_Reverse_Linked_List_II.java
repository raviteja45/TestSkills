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
        ListNode temp_head = head;
        ListNode head1 = head;
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        while(temp_head!=null){
            if(count>=left&&count<=right){
                stack.push(temp_head.val);
            }
            temp_head = temp_head.next;
            count++;
        }
        count = 1;
        while(head!=null){
            if(count>=left&&count<=right){
                head.val = stack.pop();
            }
            head = head.next;
            count++;
        }
        return head1;
        
    }
}


/**
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]

*/
