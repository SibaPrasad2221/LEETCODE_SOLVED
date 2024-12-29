class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int sp = 0, ep = letters.length-1;
        char ans = letters[0];
        while (sp <= ep) {
            int mid = sp + (ep - sp) / 2; // integer overflow

            if (letters[mid] > target) {
                ans = letters[mid];
                ep = mid - 1;
            } else
                sp = mid + 1;
        }

        return ans;
    }
}