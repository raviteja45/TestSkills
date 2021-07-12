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
    public boolean isPalindrome(ListNode head) {
        ListNode root = head;
        Stack<Integer> stack = new Stack<>();
        while(root!=null){
            stack.add(root.val);
            root = root.next;
        }
        while(!stack.isEmpty()&&head!=null){
            int x = stack.pop();
            if(head.val!=x){
                return false;
            }
            head = head.next;
        }
        return true;
        
    }
}


/**
Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false

*/
