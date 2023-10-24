class Solution {
    public String reshape(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            String s = reshape(str);

            if(!map.containsKey(s)){
                List<String> sub_list = new ArrayList<>();
                sub_list.add(str);
                map.put(s, sub_list);
            }else{
                List<String> founded_list = map.get(s);
                founded_list.add(str);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String str : map.keySet()){
            ans.add(map.get(str));
        }
        return ans;
    }
}