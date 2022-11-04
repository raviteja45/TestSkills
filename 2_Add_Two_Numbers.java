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
        int carry = 0;
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        while(l1!=null||l2!=null||carry==1){
            int sum = (l1!=null?l1.val:0)+(l2!=null?l2.val:0)+carry;
            ListNode k = new ListNode(sum%10);
            temp.next = k;
            temp = temp.next;
            if(sum>=10){
             carry = 1;   
            }else{
                carry = 0;
            }
            l1 = l1!=null ? l1.next:null;
            l2 = l2!=null ? l2.next:null;  
        }
        return head.next;
    }
}

------------------------------V2---------------------------------------
    
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
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        while(l1!=null){
            q1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            q2.add(l2.val);
            l2 = l2.next;
        }
        ListNode res = new ListNode();
        ListNode head = res;
        int carry = 0;
        while(!q1.isEmpty()||!q2.isEmpty()){
            int temp1 = q1.isEmpty()?0:q1.poll();
            int temp2 = q2.isEmpty()?0:q2.poll();
            int fin = temp1+temp2+carry;
            ListNode listNode = new ListNode(fin%10);
            carry = fin/10;
            res.next = listNode;
            res = listNode;
        }
        if(carry>0){
            ListNode temp = new ListNode(carry);
            res.next = temp;
            res  = temp;
        }
        return head.next;
    }
}

/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/
