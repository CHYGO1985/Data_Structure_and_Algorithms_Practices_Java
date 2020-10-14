/**
 * 
 * 148. Sort List
 * 
 * @CHYGO1985
 * @history Oct 14, 2020
 * 
 * ref: https://www.youtube.com/watch?v=M1TwY0nsTZA&t=321s&ab_channel=HuaHua
 * 
 */
class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        // get len of list
        int listLen = 1;
        ListNode shift = head;
        while (shift.next != null) {
            listLen ++;
            shift = shift.next;
        }

        // merge the list when 2, 2*2, 2*n ... len
        ListNode dummy = new ListNode(0, head);
        ListNode left;
        ListNode right;
        ListNode shiftHead;

        for (int count = 1; count < listLen; count = count * 2) {
            shift = dummy.next;
            shiftHead = dummy;
            while (shift != null) {

                left = shift;
                right = split(left, count);
                // shift move to the head of unsorted part
                shift = split(right, count);
                // 0: merged list head 1: merged list tail
                ListNode[] newList = merge(left, right);
                shiftHead.next = newList[0];
                shiftHead = newList[1];
            }

        }
        
        return dummy.next;
    }

    // split the list into two, the first n and the rest. 
    // return the head of the rest
    private ListNode split(ListNode head, int count) {
        
        while (-- count > 0 && head != null) {
            head = head.next;
        }

        ListNode restHead = (head == null ? null : head.next);

        // disconnect the first n with the rest
        if (head != null) head.next = null;

        return restHead;
    }

    // merge two list in ascending order
    private ListNode[] merge(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        tail.next = (head1 == null ? head2 : head1);
        while (tail.next != null) {
            tail = tail.next;
        }

        return new ListNode[]{dummy.next, tail};
    }
}

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