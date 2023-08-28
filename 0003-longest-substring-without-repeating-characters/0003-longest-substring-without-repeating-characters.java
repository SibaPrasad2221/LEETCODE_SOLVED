class Solution {
    public boolean all_unique(HashMap<Character, Integer> map){
        for(char key: map.keySet()){
            if(map.get(key) > 1) return false;
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        //we will solve it using two pointer approach

        String long_substring = "";
        int long_substr_len =0 ;

        int sp=0;
        int ep=0;
        while(ep<s.length()){

            //add
            char ch = s.charAt(ep);
            map.put(ch, map.getOrDefault(ch, 0) +1);

            //shrinking
            while(!all_unique(map)){
                char rem_ch = s.charAt(sp);
                map.put(rem_ch, map.getOrDefault(rem_ch, 0) -1); //remove that character frquency
                sp++;
            }
            if(ep-sp+1 > long_substr_len) long_substr_len = ep-sp+1;

            ep++;
        }
        return long_substr_len;
    }
}