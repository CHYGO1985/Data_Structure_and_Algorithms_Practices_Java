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
        dummy.next.next = null;

        while (unsorted != null) {

          ListNode pre = dummy.next, shift = pre;
          while (shift != unsorted) {

            if (unsorted.val >= shift.val) {
              if (shift.next != null) {
                pre = shift;
                shift = shift.next;
              } else { // if shift is the last ele

                ListNode tmp = unsorted.next;
                unsorted.next = null;
                shift.next = unsorted;
                unsorted = tmp;
                break;
              }
            } else { // when unsorted.val < shift.val

              ListNode tmp = unsorted.next;

              if (pre == shift) { // when unsorted is less than the first ele in the sorted list
                unsorted.next = dummy.next;
                dummy.next = unsorted;
              } else { // when unsorted is less then shift (in the mid of sorted list)
                unsorted.next = shift;
                pre.next = unsorted;
              }

              unsorted = tmp;
              break;
            }
          }
        }

        return dummy.next;
  }
}