class Solution {
    // public boolean check(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
    //     for(char ch: map1.keySet()){
    //         if(!map2.containsKey(ch)) return false; //if that key is not presnet in second hashmap

    //         if(map1.get(ch) != map2.get(ch)) return false;
    //     }

    //     return true;
    // }
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        // HashMap<Character, Integer> map1 = new HashMap<>();
        // HashMap<Character, Integer> map2 = new HashMap<>();

        // for(char ch: s.toCharArray()) map1.put(ch, map1.getOrDefault(ch,0) +1);
        // for(char ch: t.toCharArray()) map2.put(ch, map2.getOrDefault(ch,0) +1);

        // return check(map1,map2);
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch,0) +1);
        for(char ch: t.toCharArray()) map.put(ch, map.getOrDefault(ch,0) - 1); //if the value present before decrement the count

        //till here every character is balanced out and should be frequency as zero if both are anagrams.
        for(int val: map.values()){
            if(val!=0) return false;
        }

        return true;
    }
}