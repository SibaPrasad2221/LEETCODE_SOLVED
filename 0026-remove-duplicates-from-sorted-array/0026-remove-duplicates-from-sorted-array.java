class Solution {
    public int removeDuplicates(int[] nums) {
        //we can solve this problem using existing data strcuture

        HashSet<Integer> set = new HashSet<>();
        int i=0;
        for(int num: nums){
            if(!set.contains(num)){
                nums[i] = num;
                set.add(num);
                i++;
            }
        }

        return set.size();
    }
}