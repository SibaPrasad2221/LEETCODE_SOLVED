class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n;
        for(int i=0;i<nums.length;i++){
            n = nums[i];
            if(map.containsKey(n)) ans.add(n);
            map.put(n,map.getOrDefault(n, 0)+1);
        }
        return ans;
    }
}