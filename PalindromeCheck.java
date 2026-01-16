class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class PalindromeCheck {
    public boolean isPalindrome(ListNode head) {
        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Reverse second half
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Step 3: Compare first and second halves
        ListNode first = head, second = prev;
        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    //main method to test function
    public static void main(String[] args) {
        // Test case 1
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(2);
        n1.next.next.next = new ListNode(1);
        PalindromeCheck pc1 = new PalindromeCheck();
        System.out.println("1 -> 2 -> 2 -> 1: "+pc1.isPalindrome(n1)); // output: true
        
        // Test case 2
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(2);
        PalindromeCheck pc2 = new PalindromeCheck();
        System.out.println("1 -> 2: "+ pc2.isPalindrome(n2)); // output: false
        
        
        
    }
}

/*
 C. Write the total time for your method in the form of T(n) where n is the input size. Explain how you write T(n).

   Since isPalindrome function traverse the list 3 time it makes 3n operations. We can simply write it as T(n) = O(n)

 D. Explain the worst-case time complexity for your method in comments. You may use Big-O or theta complexity.
   Step 1: Find middle: (O(n)), in worst case, it traverses all list
   Step 2: Reverse second half: (O(n)), in worst case, it traverses all list
   Step 3: Compare first and second halves: (O(n)), in worst case, it traverses all list
   Total: in total there are 3n operations but we can simplify it as O(n).
*/




