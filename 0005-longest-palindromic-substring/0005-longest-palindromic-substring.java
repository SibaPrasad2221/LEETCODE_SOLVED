class Solution {
    public boolean isPalindDrome(String s){
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int sp = 0;
        int ep = 0;
        int len = s.length();
        int maxLen = 0;
        String longPal = "";

        // Iterate through all possible substrings
        for (ep = 0; ep < len; ep++) {
            for (sp = 0; sp <= ep; sp++) {
                // Extract the current substring
                String curr = s.substring(sp, ep + 1);
                
                // Check if it's a palindrome
                if (isPalindDrome(curr) && curr.length() > maxLen) {
                    maxLen = curr.length();
                    longPal = curr;
                }
            }
        }

        return longPal;
    }
}
