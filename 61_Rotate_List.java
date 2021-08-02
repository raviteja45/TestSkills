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
        if(head==null){
            return null;
        }
        if(k==0){
            return head;
        }
       ListNode root = head;
        int length = 1;
        while(root.next!=null){
            root = root.next;
            length = length+1;
        }
        root.next = head;
        k = k%length;
        for(int i=0;i<length-k;i++){
            root = root.next;
        }
        head = root.next;
        root.next = null;
        return head;
        
        
    }
}

/**
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]

*/
