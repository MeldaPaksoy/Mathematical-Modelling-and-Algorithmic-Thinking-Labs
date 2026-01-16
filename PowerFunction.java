public class PowerFunction {
    
    // Recursive pow(x,y) method to calculate x^n
    public static int pow(int x, int n) {
        // Base case: if n=0 (power=0), return 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: x^n = x * x^(n-1)
        return x * pow(x, n - 1);
    }

    // main method to test function
    public static void main(String[] args) {
        // Test cases
        System.out.println("2^10 = " + pow(2, 10)); // Output: 1024
        System.out.println("3^3 = " + pow(3, 3));   // Output: 27
    }
}


/* 3. Write the total running time in the form of T(n). 
    The function calls itself n times and reduces n by 1 each time.
    In each call, function does a constant work: Multiplication and calling itself
    T(n) = T(n-1) + O(1), with T(0) = O(1).
    Therefore, T(n) = O(n).
*/


/* 4. Apply Master Theorem on your T(n) to determine the time complexity of your code.
   From question 3, T(n) = T(n-1) + O(1).
   a = 1, b = 1, f(n) = O(1)
   T(n) = aT(n/b) + f(n)
   Since f(n) = O(n^0), we compare logb(a) = log1(1) = 0 with f(n).
   Since f(n) = O(n^c) where c = 0, and f(n) dominates logb(a), the complexity is O(n).
*/


/* 5. How can you solve this problem without recursion? What would its time complexity be?
    We can use a loop to multiply x with itself n times instead of recursion.
    Code:
       public static int pow(int x, int n) {
           int result = 1;
           for (int i = 0; i < n; i++) {
               result *= x;
           }
           return result;
       }
      
     In this approach, function iterates result n times.
     Time complexity for each iteration is O(1)
     Therefore time complexity = O(n)
  */

/* 6. Compare your recursive approach with this non-recursive approach in terms of their time complexity

   Both approaches have the same time complexity O(n), but iteration is simpler and shorter for this task.
 */
















