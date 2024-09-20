/**
 * 206. Reverse Linked List
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
// var reverseList = function(head) {
//   let prev = null
//   let cur = head

//   while (cur !== null) {
//       let next = cur.next
//       cur.next = prev

//       prev = cur
//       cur = next
//   }

//   return prev
// };

var reverseList = function (head) {
  if (head === null || head.next === null) {
    return head;
  }

  let headNext = head.next;
  let newHead = reverseList(head.next);
  headNext.next = head;
  head.next = null;
  return newHead;
};
