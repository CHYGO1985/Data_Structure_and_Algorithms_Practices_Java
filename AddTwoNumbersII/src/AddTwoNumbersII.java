import java.util.List;


public class AddTwoNumbersII {
	
	// method 1: two pointers technique, cal from front
	// method 2: (second round implement this one)use stack, cal from rear
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	// Method 2 : stack solution (use stack so can add from rear)
    // ref: https://discuss.leetcode.com/topic/65279/easy-o-n-java-solution-using-stack/2
    // result: runtime 68ms, beat 30%
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
    */

	// non - stack solution
	/*
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
               
               //*** very easy to forget, when the length growth, update the maxLen and carryIndex
               ListNode temp = begin;
               int len = 0;
               while (temp != null) {
                   len ++;
                   temp = temp.next;
               }
               if (len > maxLen) {
            	   carryIndex ++;
            	   maxLen = len;
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
    
	*/

}
