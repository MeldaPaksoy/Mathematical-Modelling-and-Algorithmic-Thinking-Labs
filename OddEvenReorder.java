
// Node class for singly linked list
class Node {
    int data;
    Node next;

    // Constructor with integer parameter
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class OddEvenReorder {

    //  printList(Node head) method to print the elements of the given singly linked list.
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Node reorder(Node head) method to reorder the list
    public static Node reorder(Node head) {
        if (head == null || head.next == null) return head;

        // Defining odd and even pointers
        Node odd = head;
        Node even = head.next;
        // evenHead node to connect evens at the end of the list
        Node evenHead = even;

        // Traversing nodes
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // Connecting odds list to evens list with evenHead node
        odd.next = evenHead;

        return head;
    }

    
    // main method to test the functions
    public static void main(String[] args) {
        // Example 1: [1, 2, 3, 4, 5]
        int[] arr1 = {1, 2, 3, 4, 5};
        Node head1 = createList(arr1);
        System.out.println("Original list:");
        printList(head1);
        head1 = reorder(head1);
        System.out.println("Reordered list:");
        printList(head1);

        // Example 2: [2, 1, 3, 5, 6, 4, 7]
        int[] arr2 = {2, 1, 3, 5, 6, 4, 7};
        Node head2 = createList(arr2);
        System.out.println("\nOriginal list:");
        printList(head2);
        head2 = reorder(head2);
        System.out.println("Reordered list:");
        printList(head2);
    }

    // createList(int[arr]) method to create linked list from array
    public static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    
}

    /*
      5. What is the worst-case time complexity of your reorder method?
        
        reorder(Node head) method traverses the list only one time.
        If size of the list is n, it makes n iteration.
        In each iteration, one node is visited and rearranged. 
        Visiting node has 1 primary operation and rearranging include 3 primary operations.
        Additionally, printList(Node head) method traverses list 1 times this makes n operations.
        Sum of these makes 6n operations in total but we can simplify it to n operations.   
        Therefore the total time complexity is O(n).
     */

    /*
      6. What is the worst-case space complexity of your reorder method? 
      
       Number of pointers of the reorder method is a constant which is 3. (odd, even, evenHead).
       It does not use any extra data structures like arrays or lists.
       So it makes 3 but we can simplify it to 1. 
       Therefore, the extra space complexity is O(1).
     */

