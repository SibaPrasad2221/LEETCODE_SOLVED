class Solution {

    public boolean isvalid_curr(HashMap<Character, Integer> ideal, HashMap<Character, Integer> curr){
        for(char c: ideal.keySet()){

            if(curr.containsKey(c)==false) return false;


            if(curr.get(c) < ideal.get(c)) return false; 
            //if freq is equal or greater then acceptable
        }

        return true;//it's valid
    }

    public String minWindow(String s, String t) {
        //we need two hashmap for ideal substring (ie; for T) and current substring(for which we are iterating through)

        HashMap<Character, Integer> ideal = new HashMap<>();
        HashMap<Character, Integer> curr = new HashMap<>();

        for(char c: t.toCharArray()){
            ideal.put(c, ideal.getOrDefault(c,0 ) +1 );
        }

        int sp=0;
        int ep=0;

        int ansLen = Integer.MAX_VALUE;
        String final_ans="";


        while(ep<s.length()){
            //add
            char curr_char = s.charAt(ep);
            curr.put(curr_char, curr.getOrDefault(curr_char, 0) +1);

            while(isvalid_curr(ideal, curr)){

                //update the ans if it's smaller in length than previous potential answer
                if(ep-sp+1 < ansLen){
                    ansLen = ep-sp+1;

                    final_ans = s.substring(sp, ep+1);
                }

                //now shrink
                char shrink_char_from_st = s.charAt(sp);
                sp++;//now we shrink the character ie; move to next character 
                
                     //now time to do changes in hashmap also
                curr.put(shrink_char_from_st, curr.get(shrink_char_from_st) -1);
            }

            ep++;

        }

        return final_ans;
    }

}