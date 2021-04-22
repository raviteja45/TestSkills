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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode head_odd = odd;
        ListNode head_even = even;
        int i=1;
        while(head!=null){
            if(i%2==0){
                ListNode temp = new ListNode(head.val);
                even.next = temp;
                even = even.next;
                
            }else{
                 ListNode temp = new ListNode(head.val);
                odd.next = temp;
                odd = odd.next;
                
            }
            head = head.next;
            i = i+1;
        }
        odd.next = head_even.next;
        return head_odd.next;
    }
}


/**Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]*/
