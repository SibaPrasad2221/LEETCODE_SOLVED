import java.util.*;

class Solution {
    public boolean checkIdeal(HashMap<Character, Integer> ideal, HashMap<Character, Integer> currentWindow) {
        return ideal.equals(currentWindow);
    }

    public List<Integer> findAnagrams(String s, String p) {
        // Base condition
        if (s.length() < p.length()) return new ArrayList<>();

        int sp = 0, ep = 0;
        HashMap<Character, Integer> ideal = new HashMap<>();
        for (char ch : p.toCharArray()) {
            ideal.put(ch, ideal.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> currentWindow = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        while (ep < s.length()) {
            // Add the current character to the window
            char ch = s.charAt(ep);
            currentWindow.put(ch, currentWindow.getOrDefault(ch, 0) + 1);

            // Check if the current window matches the size of `p`
            if (ep - sp + 1 == p.length()) {
                if (checkIdeal(ideal, currentWindow)) {
                    ans.add(sp);
                }

                // Remove the leftmost character of the window to slide
                char leftChar = s.charAt(sp);
                currentWindow.put(leftChar, currentWindow.get(leftChar) - 1);
                if (currentWindow.get(leftChar) == 0) {
                    currentWindow.remove(leftChar);
                }
                sp++;
            }

            ep++; // Expand the window by moving the end pointer
        }

        return ans;
    }
}
