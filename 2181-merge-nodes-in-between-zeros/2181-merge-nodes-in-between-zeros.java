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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode curr= head;
		ListNode dummy = new ListNode(0);
		ListNode itr = dummy;
        
		while(curr!=null)
        {
			int sum = 0;
			while(curr!=null && curr.val == 0)
				curr = curr.next;
			
			while(curr!=null && curr.val != 0){
				sum += curr.val;
				curr = curr.next;
			}
			if(sum != 0) {
				ListNode newNode = new ListNode(sum);
				itr.next = newNode;
				itr = itr.next; 
            }
		}
		return dummy.next;
    }
}