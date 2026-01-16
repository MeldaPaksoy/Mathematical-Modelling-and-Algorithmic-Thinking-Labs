
public class question3 {

	// recursive function to solve Tower of Hanoi problem
    public static void towerOfHanoi(int n, char source, char helper, char destination) {
    	// Base case: If there is only one disk, move it directly to the destination
    	if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
    	// Move n-1 disks from source to helper using destination as auxiliary
        towerOfHanoi(n - 1, source, destination, helper);
        // Move the nth (largest) disk from source to destination directly
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        // Move the n-1 disks from helper to destination using source as auxiliary
        towerOfHanoi(n - 1, helper, source, destination);
    }
	
	
	
    // main method to test the function
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Test case for Tower of Hanoi
        int disks = 3;
        towerOfHanoi(disks, 'A', 'B', 'C');
		
		
	}

}



/*
  
C. Apply the Tree method to write the total time for your code in the form of T(n) where n is the input size. Explain how you write T(n).

The recurrence relation is: T(n) = 2T(n-1) + O(1)

Expanding the recurrence:
T(n) = 2T(n-1) + 1
     = 2(2T(n-2) + 1) + 1
     = 4T(n-2) + 2 + 1
     = 8T(n-3) + 4 + 2 + 1
     = ...
     = 2^k T(n-k) + (2^k - 1)

Stopping when n-k = 1 (base case T(1) = O(1)):
T(n) = 2^(n-1) T(1) + (2^(n-1) - 1)

Since T(1) = O(1), T(n) = O(2^n)

D. Explain the worst-case time complexity for your method in comments. You may use Big-O or theta complexity.

  The worst case occurs when there are maximum recursive calls for n disks.
  The total number of moves follows the exponential growth of 2^n - 1.
  Therefore, the worst-case time complexity is O(2^n).
  
 */



