class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        //TC: O(N)
        //SC: O(1)
        
        int temp = 0; 
        int start = 0; 
        int end = 0; 
        int n = nums.length; 
        int countOfOdd = 0; 
        int ans = 0; 
        while(end < n){
            if(nums[end] % 2 == 1){
                countOfOdd++; 
                temp = 0; 
            }
            while(countOfOdd == k && start <= end){
                temp++; 
                if(nums[start] % 2 == 1){
                    countOfOdd--; 
                }
                start++; 
            }
            ans += temp; 
            end++; 
        }
        return ans; 
    }
}