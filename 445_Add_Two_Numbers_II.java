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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> sta1 = new Stack<>();
        Stack<Integer> sta2 = new Stack<>();
        while(l1!=null){
            sta1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            sta2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode next = null;
        while(!sta1.isEmpty()||!sta2.isEmpty()){
            int sum = (sta1.isEmpty()?0:sta1.pop())+
                      (sta2.isEmpty()?0:sta2.pop())+carry;
            int k = sum%10;
            carry = sum/10;
            ListNode listNode = new ListNode(k);
            listNode.next=next;
            next = listNode;
        }
        if(carry>0){
            ListNode k = new ListNode(carry);
            k.next = next;
            next = k;
        }
        
        return next;
    }
}



/**
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]

*/
