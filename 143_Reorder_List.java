class Solution {
    public void reorderList(ListNode head) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> list = new LinkedList<>();
        int n = 0;
        while(temp1!=null){
            stack.push(temp1);
            temp1 = temp1.next;
            n = n+1;
        }
        while(temp2!=null){
            list.add(temp2);
            temp2 = temp2.next;
        }
        list.poll();
        for(int i=1;i<n;i++){
            ListNode temp = null;
            if(i%2!=0){
               temp =  stack.pop();
                temp.next = null;
            }else{
                temp = list.poll();
                temp.next = null;
            }
            head.next = temp;
            head = temp;
        }
        
    }
}
