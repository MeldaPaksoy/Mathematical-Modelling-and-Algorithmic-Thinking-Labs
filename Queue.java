import java.util.Stack;

class Queue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // enqueue (int x) method to insert element x to the back of the queue
    public void enqueue(int x) {
        s1.push(x); // Push to s1
    }

    //  dequeue() method to remove the element from the front of the queue and return it
    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop()); // Move elements to s2
            }
        }
        return s2.pop();
    }

    // peek() method to return the element at the front of the queue
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    //  isEmpty() method to return true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // main method to test functions
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.peek()); // output: 10
        System.out.println(queue.dequeue()); // output: 10
        System.out.println(queue.peek()); // output: 20
        System.out.println(queue.isEmpty()); // output: false
    }
}

/*
   Write the total time for each method in the form of T(n) where n is the input size. Explain how you write T(n)
     enqueue: T(n) = O(1), it has just 1 operation
     dequeue: T(n) = O(n) in worst case, it iterates s1 1 times and push and pop each element this makes 3n operations but we can simply write n
     peek: T(n) = O(n), in worst case, it iterates s1 1 times and push and pop each element this makes 3n operations but we can simply write n
     isEmpty: T(n) = O(1), it has 1 primary operation

   Explain the worst-case time complexity for each method in comments.
     Enqueue: O(1), in worst case, it has just 1 operation
     Dequeue and peek: O(n), in worst case, it iterates s1 1 times and push and pop each element this makes 3n operations but we can simply write n
     isEmpty is O(1), in worst case, it has 1 primary operation
*/
