class Solution {
    public int countKDifference(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length ; i++){
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i])+1);
            }
            else
               hm.put(nums[i],1);
        }
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i]+k)) count+= hm.get(nums[i]+k);
        }
        return count;
    }
}