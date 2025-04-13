class Solution {
    public int[] runningSum(int[] nums) {
        int pref_sum=0;
        for(int i=0;i<nums.length;i++){
            pref_sum += nums[i];
            nums[i] = pref_sum;
        }
        return nums;
    }
}