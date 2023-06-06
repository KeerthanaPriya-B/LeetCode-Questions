/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       
        if(head == null) return head;
        
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        
        //copying all the node to hashmap
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        
        //for each node in map, assigning random & next pointer;
        while(curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }
}