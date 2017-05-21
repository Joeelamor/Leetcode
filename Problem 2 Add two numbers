Problem 2 Add two numbers

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode Ln1 = l1;
        ListNode Ln2 = l2;
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int sum = 0;
        
        while(Ln1 != null || Ln2 != null || sum != 0) {
            if(Ln1 != null) {
                sum += Ln1.val;
                Ln1 = Ln1.next;
            }
            if(Ln2 != null) {
                sum += Ln2.val;
                Ln2 = Ln2.next;
            }
            
            ListNode cur = new ListNode(sum % 10);
            prev.next = cur;
            prev = cur;
            sum = sum / 10;
        }
        
        return head.next;
    }
}


//////////////////////////////////////////////////////

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode Ln1 = l1;
        ListNode Ln2 = l2;
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int sum = 0;
        
        while(Ln1 != null || Ln2 != null || sum != 0) {
            if(Ln1 != null && Ln2 == null) {
                // sum += Ln1.val;
                // Ln1.val = sum % 10;
                // prev.next = Ln1;
                // Ln1 = Ln1.next;
                // if(sum / 10 == 0)
                //     break;
                if (sum == 1)
                	prev.next = c(Ln1);
                else
                	prev.next = Ln1;
                break;
            } else if(Ln1 == null && Ln2 != null) {
                // sum += Ln2.val;
                // Ln2.val = sum % 10;
                // prev.next = Ln2;
                // Ln2 = Ln2.next;
                // if(sum / 10 == 0)
                //     break;
                if (sum == 1)
                	prev.next = c(Ln2);
                else
                	prev.next = Ln2;
                break;
            } else {
                if(Ln1 != null && Ln2 != null) {
                    sum = sum + Ln1.val + Ln2.val;
                    Ln1 = Ln1.next;
                    Ln2 = Ln2.next;
                }
                
                ListNode cur = new ListNode(sum % 10);
                prev.next = cur;
                prev = cur;
                sum = sum / 10;
            }
        }
        
        return head.next;
    }

   	public ListNode c (ListNode a) {
   		ListNode r = a;
   		int sum = 1;
   		while (a != null && sum == 1) {
			sum = a.val + sum;
			a.val = sum % 10;
			sum = sum / 10;
			if (a.next != null) {
				a = a.next;
			} else if (sum == 1) {
				a.next = new ListNode(1);
				a.next.next = null;
				sum = 0;
			} else {
				;
			}
   		}
   		return r;
   	}
}