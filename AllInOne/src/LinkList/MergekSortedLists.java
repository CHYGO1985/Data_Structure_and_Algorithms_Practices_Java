package LinkList;

public class MergekSortedLists {
	
	public class ListNode {
        int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode node = new ListNode(0);
        
        /*
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.val = l1.val;
                l1 = l1.next;
            } else {
                node.val = l2.val;
                l2 = l2.next;
            }
        } else if (l1 != null) {
            node.val = l1.val;
            l1 = l1.next;
        } else if (l2 != null) {
            node.val = l2.val;
            l2 = l2.next;
        } else {
            return null;
        }*/
        
        // refactoring the previous code
        if ((l1 != null && l2 == null) || (l1 != null && l2 != null && l1.val < l2.val)) {
            node.val = l1.val;
            l1 = l1.next;
        } else if ((l2 != null && l1 == null) || (l1 != null && l2 != null && l1.val >= l2.val)) {
        	node.val = l2.val;
            l2 = l2.next;
        } else {
            return null;
        }
        
        node.next = mergeTwoLists(l1, l2);
        
        return node;
    }
}
