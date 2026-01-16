import java.util.*;

public class LetterCombinations {
    // HashMap to store digit to letter mappings
    private static final Map<Character, String> digitToLetters = new HashMap<>();
    
    static {
        // Converting numbers to letters similar to a phone keypad
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }
    
    
    public static List<String> letterCombinations(String digits) {
        // If input string is empty, return an empty list
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        // calling backtrack method
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    
   // backtrack method to generate all possible combinations
    private static void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        // Base case: if index reaches the length of digits, add the combination to result
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        
        // Getting the letters corresponding to the current digit
        String letters = digitToLetters.get(digits.charAt(index));
        
        // Iterating each letter recursively
        for (char letter : letters.toCharArray()) {
            combination.append(letter); 
            backtrack(result, combination, digits, index + 1); // Repeating for the next digit
            combination.deleteCharAt(combination.length() - 1); // Removing last character to backtrack
        }
    }
    
    // main method to test functions
    public static void main(String[] args) {
        // Test cases
        System.out.println("Letter combinations for : " + letterCombinations(""));
        System.out.println("Letter combinations for 2: " + letterCombinations("2"));
        System.out.println("Letter combinations for 23: " + letterCombinations("23")); 
        System.out.println("Letter combinations for 234: " + letterCombinations("234")); 
    }
}

/*
3. What is the average time complexity (Use Big-O notation) of your method? 

 If n is the number of digits, time complexity is O(4^n) 

4. Explain why it has this time complexity

 Some digits maps to 4 letters when others maps to 3 letters.
 In the worst case scenario, all digits in input map to 4 letters. And total number of combinations grows exponentially.
 Therefore time complexity is O(4^n).
    
 
*/




