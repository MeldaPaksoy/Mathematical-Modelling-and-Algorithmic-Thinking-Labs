
public class JumpingGame {

	// canJump method to see if the array is true or false
    public static boolean canJump(int[] nums) {
    	// int variable to define the last index (# of work= 1)
        int lastReachable = nums.length - 1; 

        // Traversing array from right to left (# of work= n)
        for (int i = nums.length - 2; i >= 0; i--) { 
            // If index i + max jump from here reaches or passes lastReachable, update lastReachable to i (# of work= 1 for each iteration)
            if (i + nums[i] >= lastReachable) {
            	
            	// Updating the last reachable index (# of work= 1)
                lastReachable = i; 
            }
        }

        // If we reach index 0, return true, otherwise false (# of work= 1)
        return lastReachable == 0;
    }
	
	
	
	// main method to test the function
    public static void main(String[] args) {
        // Test Case 1 (Expected Output: true)
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("2, 3, 1, 1, 4: " + canJump(nums1));

        // Test Case 2 (Expected Output: false)
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("3, 2, 1, 0, 4: " + canJump(nums2));
    }

}


/*
3. Write the total running time in the form of T(n). Write the total number of works that is done in each line as comment line. 

Total Running Time T(n)= 
(defining lastReachable: 1 work) + 
(Since for runs (n-1) times: n work)+
(Inside the loop, Constant time operations (1 work each iteration))= 
Total Work = n + 1 + 1 = O(n)


4. What is the average time complexity of your code?  

The code traverses the array only one time, this makes at most one constant-time operation for each element.
Therefore, if n= size of the input array, the average time complexity is O(n).
*/
