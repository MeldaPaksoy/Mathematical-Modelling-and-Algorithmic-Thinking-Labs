	
//  Node class to make int type singly linked lists
class Node {
	    int data;
	    Node next;
	    
	    // Constructor with int parameter
	    public Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}

	class SinglyLinkedList {
		
		private Node head;
		
		//Costructor
	    public SinglyLinkedList() {
	    	//Accessing head node
	        this.head = null;
	    }
		
		
	    // Method to print the linked list
	    public static void printList(Node head) {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data + " -> ");
	            current = current.next;
	        }
	        System.out.println("NULL");
	    }
	    
	    // Method to reverse a sublist from position left to right
	    public static Node reverseBetween(Node head, int left, int right) {
	        if (head == null || left == right) return head;
	        
	        Node newNode = new Node(0); // node to simplify edge cases
	        newNode.next = head;
	        Node prev = newNode;
	        
	        // Move prev to the node before the left position
	        for (int i = 1; i < left; i++) {
	            prev = prev.next;
	        }
	        
	        Node current = prev.next;
	        Node next;
	        
	        // For loop to reverse nodes between left and right
	        for (int i = 0; i < right - left; i++) {
	            next = current.next;
	            current.next = next.next;
	            next.next = prev.next;
	            prev.next = next;
	        }
	        
	        return newNode.next;
	    }
	    
	    
	    // main method to testing functions
	    public static void main(String[] args) {
	        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
	        Node head = new Node(1);
	        head.next = new Node(2);
	        head.next.next = new Node(3);
	        head.next.next.next = new Node(4);
	        head.next.next.next.next = new Node(5);
	        
	        System.out.println("Original List:");
	        printList(head);
	        
	        // Reverse between positions 2 and 4
	        head = reverseBetween(head, 2, 4);
	        
	        System.out.println("Reversed List (Between positions 2 and 4):");
	        printList(head);
	    }
	}



	/*
	What is the worst-case time complexity of your reverse method? Explain it in the comment lines in your code.
	
	Worst case is reversing all nodes in Singly Linked List.
	In that case function iterates all elements and changes their position 1 times this makes 3n process. 
	We can simplify it to n. Therefore time complexity is O(n)
	
	*/




