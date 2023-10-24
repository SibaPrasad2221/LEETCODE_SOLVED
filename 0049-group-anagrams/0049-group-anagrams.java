class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap< HashMap<Character, Integer>, ArrayList<String> > hmap = new HashMap<>();
        for(String str: strs){
            HashMap<Character, Integer> freq_map = new HashMap<>();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                freq_map.put(ch, freq_map.getOrDefault(ch, 0) + 1);
            }

            if(!hmap.containsKey(freq_map)){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hmap.put(freq_map, list);
            }else{
                //if that freq map alreay exist
                //and as it's exist get it's value whihc is nothing but a arraylist and update the arraylist

                ArrayList<String> found_list = hmap.get(freq_map);
                found_list.add(str);

                // hmap.put(freq_list, found_list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(HashMap<Character, Integer> sub_map : hmap.keySet()){
            ans.add(new ArrayList<>(hmap.get(sub_map)));
        }

        return ans;
    }
}