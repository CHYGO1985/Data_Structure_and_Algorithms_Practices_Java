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
/**
 * 
 * 2. Add Two Numbers
 * 
 * @author jingjiejiang
 * @history Apr 5, 2021
 * 
 */
class AddTwoNumbers {
  // add new val to l1
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
    assert l1 != null && l2 != null;

    ListNode dummy = new ListNode(1, l1);
    ListNdoe preL1, preL2;

    if (l1 == null) return l2;
    if (l2 == null) return l1;

    int carry = 0;
    while (l1 != null && l2 != null) {

      int curVal = l1.val + l2.val + carry;

      carry = curVal / 10;
      int newVal = curVal % 10;

      l1.val = newVal;

      preL1 = l1;
      preL2 = l2;
      l1 = l1.next;
      l2 = l2.next;
    }

    // if l2 != null (l1 == null), we link l1 to l2, and treat l2 as l1
    if (l2 != null) {
      preL1.next = l2;
      l1 = l2;
    }

    // l1 != null
    while (l1 != null && carry > 0) {

      int curVal = l1.val + carry;
      
      carry = curVal / 10;
      int newVal = curVal % 10;

      l1.val = newVal;
      preL1 = l1;
      l1 = l1.next;
    }

    if (carry > 0) {
      l1 = preL1;
      l1.next = new ListNode(carry);
    }

    return dummy.next;
  }
}
