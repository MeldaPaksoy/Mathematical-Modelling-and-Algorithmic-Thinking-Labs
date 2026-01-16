		
    import java.util.LinkedList;
	import java.util.Queue;

	class Question1 {
	    Queue<Integer> q1 = new LinkedList<>();
	    Queue<Integer> q2 = new LinkedList<>();

	    // push(int x) method to push element x to the top of the stack 
	    public void push(int x) {
	    	 // Adding a new element to q2
	        q2.add(x);
	        while (!q1.isEmpty()) {
	        	// Moving all elements of q1 to q2
	            q2.add(q1.poll()); 
	        }
	        // Swapping q1 and q2
	        Queue<Integer> temp = q1;
	        q1 = q2;
	        q2 = temp;
	    }

	    // int pop() method to remove the element on the top of the stack and return it
	    public int pop() {
	        return q1.poll(); // Front of q1 is the top of stack
	    }

	    // int top() method to return the element on the top of the stack
	    public int top() {
	        return q1.peek();
	    }

	    // boolean isEmpty() method to return true if the stack is empty, false otherwise
	    public boolean isEmpty() {
	        return q1.isEmpty();
	    }

	    // main method to test functions
	    public static void main(String[] args) {
	    	Question1 stack = new Question1();
	        stack.push(10);
	        stack.push(20);
	        stack.push(30);
	        System.out.println(stack.top()); // output: 30
	        System.out.println(stack.pop()); // output: 30
	        System.out.println(stack.top()); // output: 20
	        System.out.println(stack.isEmpty()); // output: false
	    }
	}

	/*
	C. Write the total time for each method in the form of T(n) where n is the input size. Explain how you write T(n).
	push method: T(n) = O(n), it has 2n+2 operations because it iterates list 2 times and operates isEmpty and add operations whish has 1 primary operations. But we can simplify 2n+2 to n  
	pop method: T(n) = O(1), it has 1 primary operation
	top method: T(n) = O(1), it has 1 primary operation
	isEmpty method: T(n) = O(1), it has 1 primary operation

	 D. Explain the worst-case time complexity for each method in comments.
	  push method has 2n+2 operations because it iterates list 2 times and operates isEmpty and add operations which has 1 primary operations. 
	  But we can simplify 2n+2 to n. Therefore its worst case time complexity= O(n)
	
	  pop, top, isEmpty are O(1) because they have only 1 primary operations.
	*/

	
	
	
	
	
	
	
	
	

