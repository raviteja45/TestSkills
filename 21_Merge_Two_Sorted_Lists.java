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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        ListNode temp = new ListNode();
        ListNode head = temp;
        while(l1!=null){
            p.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            p.add(l2.val);
            l2 = l2.next;
        }
        int size = p.size();
        for(int i=0;i<size;i++){
            ListNode k = new ListNode(p.poll());
            temp.next = k;
            temp = temp.next;
        }
        
        return head.next;
    }
}


/**
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

 

Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


*/
