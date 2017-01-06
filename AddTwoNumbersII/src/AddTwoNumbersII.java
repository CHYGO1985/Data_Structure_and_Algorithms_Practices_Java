import java.util.List;


public class AddTwoNumbersII {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // idea: Method 1: recursive + two pointers technique
        // ref: http://bookshadow.com/weblog/2016/10/29/leetcode-add-two-numbers-ii/
        
        ListNode temp = l1;
        int len1 = 0;
        while (temp != null) {
            len1 ++;
            temp = temp.next;
        }
        
        temp = l2;
        int len2 = 0;
        while (temp != null) {
            len2 ++;
            temp = temp.next;
        }
        
        if (null == l1) {
            return l2;
        }
    
        if (null == l2) {
            return l1;
        }
        
        int maxLen = Math.max(len1, len2);
        int dif = Math.abs(len1 - len2);
        ListNode maxList = null;
        ListNode minList = null;
        if (len1 >= len2) {
            
            maxList = l1;
            minList = l2;
        }
        else {
            maxList = l2;
            minList = l1;
        }
        
        return calSum(maxList, minList, maxLen, dif);
    }
    
    public static ListNode calSum(ListNode maxList, ListNode minList, int maxLen, int dif) {
        
        int carry = 0;
        ListNode begin = maxList;
        int carryIndex = 0;
        
        while (dif > 0) {
            maxList = maxList.next;
            carryIndex ++;
            dif --;
        }
        
        while (maxList != null && minList != null) {
            int sum = maxList.val + minList.val;
            
            maxList.val = sum % 10;
            carry = sum / 10;
            if (carry > 0) {
               begin = addCarry(begin, carry, carryIndex - 1);
               ListNode temp = begin;
               int len = 0;
               while (temp != null) {
                   len ++;
                   temp = temp.next;
               }
               if (len > maxLen) {
            	   carryIndex ++;
               }
            }
            
            maxList = maxList.next;
            minList = minList.next;
            carryIndex ++;
        }
        
        return begin;
    }
    
    public static ListNode addCarry(ListNode begin, int carry, int carryIndex) {
        
    	if (carryIndex < 0) {
            ListNode newBegin = new ListNode(carry);
            newBegin.next = begin;
            return newBegin;
        }
    	
        ListNode temp = begin;
        int count = 0;
        
        while (count != carryIndex) {
            temp = temp.next;
            count ++;
        }
        
        int digit = (temp.val + carry) % 10;
        carry = (temp.val + carry) / 10;
        temp.val = digit;
    
        
        if (0 == carry) {
            return begin;
        }
        
        // if carry > 0
        return addCarry (begin, carry, carryIndex - 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(1);
		*/
		
		/*
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		*/
		
		/*
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(2);
		*/
		
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(2);
		
		l1 = addTwoNumbers(l1, l2);
	}

}
