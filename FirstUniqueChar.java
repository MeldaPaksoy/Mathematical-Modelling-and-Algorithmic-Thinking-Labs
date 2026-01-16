import java.util.*;

class FirstUniqueChar {
    public int firstUniqChar(String s) {
    	// Frequency array
        int[] freq = new int[26]; 
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
        	// if first unique char found
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i; 
            }
        }
        return -1;
    }

 //   main method to test function
    public static void main(String[] args) {
        // Test cases
        FirstUniqueChar fuc = new FirstUniqueChar();
        System.out.println("leetcode: "+fuc.firstUniqChar("leetcode")); // 0
        System.out.println("loveleetcode: "+ fuc.firstUniqChar("loveleetcode")); // 2
        System.out.println("aabb: " + fuc.firstUniqChar("aabb")); // -1
    }
}

/*
  C. Write the total time for your method in the form of T(n) where n is the input size. Explain 
  how you write T(n). 
    In worst case function iterates all elements 2 times this makes 2n process but we can simplify it as n therefore T(n) = O(n)

  D. Explain the worst-case time complexity for your method in comments. You may use Big-O 
  or theta complexity.
   First pass: O(n) It iterates all elements to count frequencies
   Second pass: O(n) It iteartes all elements to find first unique
   Total: Total operation is 2n but we can simply write O(n).
*/
