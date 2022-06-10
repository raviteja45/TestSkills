class Solution {
    public ListNode sortList(ListNode head) {
        Queue<ListNode> q = new PriorityQueue<>((a,b)->a.val-b.val);
        while(head!=null){
            q.add(head);
            head = head.next;
        }
        ListNode res = new ListNode();
        ListNode hed = res;
        while(!q.isEmpty()){
            ListNode t = q.poll();
            t.next = null;
            res.next = t;
            res = t;
        }
        return hed.next;
    }
}
