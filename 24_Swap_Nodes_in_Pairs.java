class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;
        while(current.next!=null&&current.next.next!=null){
            ListNode first = current.next;
            ListNode second = current.next.next;
            current.next = second;
            first.next = second.next;
            second.next = first;
            current = first;
        }
        return dummy.next;
    }
}

//Dummy -> 1 -> 2 -> 3 -> 4,
Check 24_1 to 24_6 images


/**
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
*/
