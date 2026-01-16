package algoLab1;

import java.util.*;

public class singleNumberFinder{
	
	
	// singleNumber function to find the single number in the array 
    public static int singleNumber(int[] nums) {
        int result = 0;
        
        // for loop with XOR operation to cancel out the numbers these are written twice, leaving only the unique number
        for (int num : nums) {
            result ^= num; 
        }
        
        return result;
    }
    
	
    //main method to test singleNumber function
    public static void main(String[] args) {
        // Test cases
        int[] test1 = {2,2,1};
        int[] test2 = {4,1,2,1,2};
        int[] test3 = {1};
        
        // Printing results
        System.out.println("Test1 result: " + singleNumber(test1)); // Expected output: 1
        System.out.println("Test2 result: " + singleNumber(test2)); // Expected output: 4
        System.out.println("Test3 result: " + singleNumber(test3)); // Expected output: 1
    }
}
    
// 3. What is the average time complexity (Use Big-O notation) of your code? Write it as a comment line in your code.
//Time complexity=O(n)

// 4. 4. Explain why it has this time complexity. Write it as a comment line in your code. 
// The function iterates all elements in the array once with XOR operation.
// Since the XOR operation's complexity is O(1) if we say number of elements in array is n the time complexity= O(n)




