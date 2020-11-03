/**
 * 
 * 147. Insertion Sort List
 * 
 * @CHYGO1985
 * @history Nov 3, 2020
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
  public ListNode insertionSortList(ListNode head) {
      
    if (head == null) return null;
    
    // init variables
    ListNode dummy = new ListNode(0, head); 
    ListNode unsorted = head.next;

    while (unsorted != null) {

      ListNode pre = head, shift = head;
      while (shift != unsorted) {
        if (unsorted.val >= shift.val) {
          pre = shift;
          shift = shift.next;
        } else {
          // when unsorted is less than the first ele
          if (pre == shift) {
            
          }
        }
      }
    }

  }
}