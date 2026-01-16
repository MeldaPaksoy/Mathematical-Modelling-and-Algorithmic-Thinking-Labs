
public class question2 {

    // Function to find the minimal length of a subarray with sum >= target
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;
        
        // summing from right side 
        for (int right = 0; right < n; right++) {
            sum += nums[right]; // Expanding the window by adding the right element
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left]; // Shrinking the window from the left
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    
    
    // main method to test the function
    public static void main(String[] args) {

        // Test case 1 
        int[] nums1 = {2,3,1,2,4,3};
        int target1 = 7;
        System.out.println(minSubArrayLen(target1, nums1)); // Output: 2

        // Test case 2 
        int[] nums2 = {1,4,4};
        int target2 = 4;
        System.out.println(minSubArrayLen(target2, nums2)); // Output: 1
        
       // Test case 3 
        int[] nums3 = {1,1,1,1,1,1,1,1};
        int target3 = 11;
        System.out.println(minSubArrayLen(target3, nums3)); // Output: 0
        
    }
    
}

/*

C. Write the total time for your code in the form of T(n) where n is the input size. Explain how you write T(n).

  Right and left pointers iterates through array at most n times this makes at most 2n operation
  Therefore the total time complexity T(n) = O(n).


D. Explain the worst-case time complexity for your method in comments. You may use Big-O or theta complexity. 

  The worst case occurs when all elements are checked.
  In this case, each element is processed at most twice.
  Therefore the worst-case time complexity is O(n).

*/



