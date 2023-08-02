class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int min_size=Integer.MAX_VALUE;

        int st=0;
        int end=0;
        int sum=0;
        while(end < nums.length){
            sum += nums[end];

            while(sum >= target){
                min_size = Math.min(min_size, end-st+1);
                sum = sum - nums[st];
                st++;
            }
            end++;
        }
        // return min == Integer.MAX_VALUE ? 0 : min;

        return min_size == Integer.MAX_VALUE ? 0 : min_size;
    }
}