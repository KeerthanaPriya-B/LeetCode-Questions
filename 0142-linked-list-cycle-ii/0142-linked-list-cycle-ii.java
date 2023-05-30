/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode fast = head;
		ListNode slow = head;
		ListNode meetingNode = null;

		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;

			if(fast==slow){
				meetingNode = slow;
				break;
			}
		}
		if(meetingNode==null) return null;

		ListNode firstNode = head;

		while(meetingNode != firstNode){
			firstNode = firstNode.next;
			meetingNode = meetingNode.next;
		}

		return meetingNode;
    }
}