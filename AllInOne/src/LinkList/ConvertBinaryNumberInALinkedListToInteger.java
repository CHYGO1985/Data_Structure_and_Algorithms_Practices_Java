/**
 * 
 * 1290. Convert Binary Number in a Linked List to Integer
 * 
 * @author jingjiejiang
 * @history Nov 2, 2020
 * 
 */

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
  public int getDecimalValue(ListNode head) {
      
    if (head == null) return 0;
    int len = 0;

    ListNode dummy = new ListNode(0, head);

    // cal the length of the list
    while (head.next != null) {
      len ++;
      head = head.next;
    } 

    head = dummy.next;
    int num = 0;

    // for 1 0 1, the len is 2, then from the head to tail, the pow is 2 1 0
    while (head != null) {
      num += (head.val * Math.pow(2, len --));
      head = head.next;
    }

    return num; 
  }
}
