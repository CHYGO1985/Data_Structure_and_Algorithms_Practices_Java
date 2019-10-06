package Design;

/**
 * 
 * @author jingjiejiang May 27, 2019
 *
 */
class MyLinkedList {
	
	private int length;
	private int val;
	private MyLinkedList head;
	private MyLinkedList tail;
	private MyLinkedList next;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    	length = 0;
    	val = 0;
    	head = new MyLinkedList();
    	tail = head;
    	next = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        
    	if (index <= 0 || index > length) return -1;
    	
    	MyLinkedList shift = head;
    	while (index > 0) {
    		shift = shift.next;
    		index --;
    	}
    	
    	return shift.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	head.val = val;
    	MyLinkedList newHead = new MyLinkedList();
    	newHead.next = head;
    	tail = head;
    	head = newHead;
    	length ++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
    	MyLinkedList newNode = new MyLinkedList();
    	newNode.val = val;
    	tail.next = newNode;
    	tail = newNode;
    	length ++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
    	if (index <= 0 || index > length) return;
    	
    	// add at tail
    	if (index == length) addAtTail(val);
    	// add at head
    	if (index == 1) addAtHead(val);
    	
    	MyLinkedList shift = head;
    	
    	while (index - 1 > 0) {
    		shift = shift.next;
    		index --;
    	}
    	
    	MyLinkedList newNode = new MyLinkedList();
    	newNode.val = val;
    	MyLinkedList shiftNext = shift.next;
    	shift.next = newNode;
    	newNode.next = shiftNext;
    	
    	length ++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	
    	if (index <= 0 || index > length) return;
    	
    	MyLinkedList preNode = head;
    	MyLinkedList shift = head;
    	
    	while (index > 0) {
    		preNode = shift;
    		shift = shift.next;
    		index --;
    	}
    	
    	preNode.next = shift.next;
    	
    	if (index == length);
    	tail = preNode;
    	length --;
    }
}
